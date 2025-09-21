package services;

import dao.Ids;
import enums.EstadoInscripcion;
import enums.TipoCheckIn;
import models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class InscripcionService {

    public Inscripcion crearInscripcion(Usuario usuario, Evento evento) {
        Objects.requireNonNull(usuario);
        Objects.requireNonNull(evento);
        return new Inscripcion(Ids.next(), usuario, evento, LocalDate.now());
    }

    public void confirmarYGenerarCredencial(Inscripcion inscripcion) {
        inscripcion.setEstado(EstadoInscripcion.CONFIRMADA);
        Credencial cred = new Credencial(
                Ids.next(),
                "QR-" + inscripcion.getId() + "-" + System.nanoTime(),
                LocalDate.now()
        );
        inscripcion.setCredencial(cred);
    }

    public void checkInEvento(Inscripcion inscripcion) {
        CheckIn c = new CheckIn(Ids.next(), LocalDateTime.now(), TipoCheckIn.EVENTO, null);
        inscripcion.getCredencial().addCheckIn(c);
    }

    public void checkInSesion(Inscripcion inscripcion, Sesion sesion) {
        CheckIn c = new CheckIn(Ids.next(), LocalDateTime.now(), TipoCheckIn.SESION, sesion);
        inscripcion.getCredencial().addCheckIn(c);
    }
}
