package models;

import java.time.LocalDate;
import enums.EstadoInscripcion;

public class Inscripcion {
    private final int id;
    private final Usuario usuario;
    private final Evento evento;
    private final LocalDate fechaRegistro;
    private EstadoInscripcion estado;
    private Credencial credencial; // 1-1

    public Inscripcion(int id, Usuario usuario, Evento evento, LocalDate fechaRegistro) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.fechaRegistro = fechaRegistro;
        this.estado = EstadoInscripcion.CREADA;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Evento getEvento() { return evento; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public EstadoInscripcion getEstado() { return estado; }
    public void setEstado(EstadoInscripcion estado) { this.estado = estado; }
    public Credencial getCredencial() { return credencial; }
    public void setCredencial(Credencial credencial) { this.credencial = credencial; }
}
