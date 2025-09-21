package models;

import java.time.LocalDate;
import enums.EstadoCertificado;

public class Certificado {
    private final int id;
    private final Usuario usuario;
    private final Evento evento;
    private final String urlPDF;
    private final LocalDate fechaEmision;
    private final EstadoCertificado estado;

    public Certificado(int id, Usuario usuario, Evento evento, String urlPDF,
                       LocalDate fechaEmision, EstadoCertificado estado) {
        this.id = id;
        this.usuario = usuario;
        this.evento = evento;
        this.urlPDF = urlPDF;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Evento getEvento() { return evento; }
    public String getUrlPDF() { return urlPDF; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public EstadoCertificado getEstado() { return estado; }
}
