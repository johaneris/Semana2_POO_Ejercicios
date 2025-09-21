package run;

import dao.InMemoryDB;
import dao.Ids;
import enums.Rol;
import enums.TipoCheckIn;
import models.*;
import services.CertificationService;
import services.InscripcionService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Rol leerRol(Scanner sc) {
        while (true) {
            System.out.println("Selecciona tu rol:");
            System.out.println("  1) PARTICIPANTE");
            System.out.println("  2) ORGANIZADOR");
            System.out.println("  3) OPERADOR");
            System.out.print("Opción: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": return Rol.PARTICIPANTE;
                case "2": return Rol.ORGANIZADOR;
                case "3": return Rol.OPERADOR;
                default:
                    System.out.println("⚠️  Opción inválida. Intenta de nuevo.\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Servicios y "BD" en memoria
        InMemoryDB db = new InMemoryDB();
        InscripcionService insSrv = new InscripcionService();
        CertificationService certSrv = new CertificationService();

        // 1) Creamos un evento de ejemplo con 3 sesiones y regla 70%
        Evento systech = new Evento(Ids.next(), "SYSTECH 2025",
                LocalDate.of(2025, 9, 10), "Olof Palme", 800);
        systech.setReglaCertificado(new ReglaCertificado(0.70));
        systech.addSesion(new Sesion(Ids.next(), "IA aplicada",         LocalTime.of(9,  0), LocalTime.of(10, 0), "Sala A"));
        systech.addSesion(new Sesion(Ids.next(), "Ciberseguridad",      LocalTime.of(10, 30), LocalTime.of(11, 30), "Sala B"));
        systech.addSesion(new Sesion(Ids.next(), "Programación Avanz.", LocalTime.of(12, 0), LocalTime.of(13, 0), "Sala C"));
        db.save(systech);

        // 2) Datos del usuario (ingresados por consola)
        System.out.println("=== Registro de Participante ===");
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        Rol rol = leerRol(sc);

        Usuario usuario = new Usuario(Ids.next(), nombre, email, rol);
        db.save(usuario);

        // 3) Inscripción al evento
        Inscripcion ins = insSrv.crearInscripcion(usuario, systech);
        insSrv.confirmarYGenerarCredencial(ins);
        db.save(ins);

        System.out.println("\n✅ Inscripción creada y confirmada.");
        System.out.println("Tu código QR es: " + ins.getCredencial().getCodigoQR());

        // 4) Check-in general del evento (opcional)
        System.out.print("\n¿Deseas hacer check-in al EVENTO ahora? (s/n): ");
        String respEvento = sc.nextLine().trim().toLowerCase();
        if (respEvento.startsWith("s")) {
            insSrv.checkInEvento(ins);
            System.out.println("✔ Check-in de EVENTO registrado.");
        }

        // 5) Listar sesiones y permitir seleccionar a cuáles asistió
        System.out.println("\nSesiones disponibles:");
        for (int i = 0; i < systech.getSesiones().size(); i++) {
            Sesion s = systech.getSesiones().get(i);
            System.out.printf("  %d) %s (%s-%s, %s)%n", i + 1, s.getTitulo(),
                    s.getHoraInicio(), s.getHoraFin(), s.getSala());
        }
        System.out.println("Ingresa los números de las sesiones a las que asististe, separados por comas.");
        System.out.println("Ejemplo: 1,3 (deja vacío si no asististe a ninguna)");
        System.out.print("Sesiones: ");
        String linea = sc.nextLine().trim();

        if (!linea.isBlank()) {
            Arrays.stream(linea.split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .forEach(tok -> {
                        try {
                            int idx = Integer.parseInt(tok) - 1;
                            if (idx >= 0 && idx < systech.getSesiones().size()) {
                                Sesion ses = systech.getSesiones().get(idx);
                                insSrv.checkInSesion(ins, ses);
                                System.out.println("✔ Check-in en SESIÓN: " + ses.getTitulo());
                            } else {
                                System.out.println("⚠️  Ítem fuera de rango: " + tok);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️  Valor inválido: " + tok);
                        }
                    });
        }

        // 6) Emitir certificado según regla
        double porcentaje = certSrv.calcularPorcentajeAsistencia(ins) * 100.0;
        Certificado cert = certSrv.emitirSiElegible(ins);
        db.save(cert);

        System.out.printf("%nAsistencia a sesiones: %.1f%%%n", porcentaje);
        System.out.println("Resultado del certificado: " + cert.getEstado());
        System.out.println("URL del PDF: " + cert.getUrlPDF());

        // Información de depuración opcional:
        System.out.println("\nResumen de Check-ins:");
        ins.getCredencial().getCheckIns().forEach(ci -> {
            String que = (ci.getTipo() == TipoCheckIn.EVENTO)
                    ? "EVENTO"
                    : ("SESIÓN: " + ci.getSesion().getTitulo());
            System.out.printf("  - %s a las %s%n", que, ci.getFechaHora());
        });

        System.out.println("\n¡Gracias por participar en " + systech.getNombre() + "!");
    }
}
