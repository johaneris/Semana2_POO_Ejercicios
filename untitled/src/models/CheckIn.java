package models;

import java.time.LocalDateTime;
import enums.TipoCheckIn;

public class CheckIn {
    private final int id;
    private final LocalDateTime fechaHora;
    private final TipoCheckIn tipo;
    private final Sesion sesion; // null si tipo = EVENTO

    public CheckIn(int id, LocalDateTime fechaHora, TipoCheckIn tipo, Sesion sesion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.tipo = tipo;
        this.sesion = sesion;
    }

    public int getId() { return id; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public TipoCheckIn getTipo() { return tipo; }
    public Sesion getSesion() { return sesion; }
}
