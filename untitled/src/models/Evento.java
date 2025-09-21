package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private final int id;
    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private int capacidad;
    private final List<Sesion> sesiones = new ArrayList<>();
    private ReglaCertificado reglaCertificado;

    public Evento(int id, String nombre, LocalDate fecha, String lugar, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.capacidad = capacidad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public LocalDate getFecha() { return fecha; }
    public String getLugar() { return lugar; }
    public int getCapacidad() { return capacidad; }
    public List<Sesion> getSesiones() { return sesiones; }
    public ReglaCertificado getReglaCertificado() { return reglaCertificado; }
    public void setReglaCertificado(ReglaCertificado reglaCertificado) { this.reglaCertificado = reglaCertificado; }
    public void addSesion(Sesion s) { sesiones.add(s); }

    @Override public String toString() {
        return "Evento{id=" + id + ", nombre='" + nombre + "', fecha=" + fecha + "}";
    }
}
