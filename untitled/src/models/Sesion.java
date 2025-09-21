package models;

import java.time.LocalTime;

public class Sesion {
    private final int id;
    private String titulo;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String sala;

    public Sesion(int id, String titulo, LocalTime horaInicio, LocalTime horaFin, String sala) {
        this.id = id;
        this.titulo = titulo;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.sala = sala;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
    public String getSala() { return sala; }

    @Override public String toString() {
        return "Sesion{id=" + id + ", titulo='" + titulo + "'}";
    }
}
