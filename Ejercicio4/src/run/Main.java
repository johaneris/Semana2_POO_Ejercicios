package run;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import models.Contacto;
import java.util.Scanner;
import models.Agenda;


//
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Agenda agenda = new Agenda();
        String opcion;

        do {
            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1) Añadir contacto");
            System.out.println("2) Mostrar todos");
            System.out.println("3) Buscar por nombre");
            System.out.println("4) Buscar por correo (exacto)");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            opcion = in.nextLine().trim(); // nextLine: lee la línea completa

            switch (opcion) { // switch con String (Java 7+)
                case "1": { // Añadir
                    Contacto nuevo = new Contacto();

                    // nombre (inline, sin helper)
                    String nombre = "";
                    while (nombre.isEmpty()) {
                        System.out.print("Nombre: ");
                        nombre = in.nextLine().trim();
                        if (nombre.isEmpty()) System.out.println("No puede estar vacío.");
                    }

                    // teléfono
                    String telefono = "";
                    while (telefono.isEmpty()) {
                        System.out.print("Teléfono: ");
                        telefono = in.nextLine().trim();
                        if (telefono.isEmpty()) System.out.println("No puede estar vacío.");
                    }

                    // correo (tu validación se ejecuta en setCorreo)
                    String correo = "";
                    while (correo.isEmpty()) {
                        System.out.print("Correo: ");
                        correo = in.nextLine().trim();
                        if (correo.isEmpty()) System.out.println("No puede estar vacío.");
                    }

                    nuevo.setNombre(nombre);
                    nuevo.setTelefono(telefono);
                    nuevo.setCorreo(correo);

                    if (nuevo.getCorreo() == null) {
                        System.out.println("No se guardó: correo inválido según la regla actual.");
                    } else {
                        agenda.guardarDatos(nuevo);
                        System.out.println("Contacto guardado.");
                    }
                    break;
                }

                case "2": { // Mostrar todos
                    System.out.println("\n--- Contactos ---");
                    agenda.mostrarContactos();
                    break;
                }

                case "3": { // Buscar por nombre (usa tu método)
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscado = in.nextLine().trim();

                    try {
                        Contacto tmp = new Contacto();
                        tmp.setNombre(nombreBuscado);
                        String r = agenda.buscarPorNombre(tmp);
                        System.out.println(r != null ? "Encontrado: " + r : "No se encontró ese nombre.");
                    } catch (NullPointerException npe) {
                        System.out.println("No hay contactos suficientes para buscar aún.");
                    }
                    break;
                }

                case "4": { // Buscar por correo
                    System.out.print("Correo a buscar (exacto): ");
                    String correoBuscado = in.nextLine().trim();

                    try {
                        Contacto tmp = new Contacto();
                        tmp.setCorreo(correoBuscado);
                        if (tmp.getCorreo() == null) {
                            System.out.println("Formato de correo no aceptado.");
                            break;
                        }
                        String r = agenda.buscarPorDominio(tmp);
                        System.out.println(r != null ? "Encontrado: " + r : "No se encontró ese correo.");
                    } catch (NullPointerException npe) {
                        System.out.println("No hay contactos suficientes para buscar aún.");
                    }
                    break;
                }

                case "0":
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (!opcion.equals("0"));

        in.close();





    }
}