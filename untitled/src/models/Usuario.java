package models;

import enums.Rol;

public class Usuario {
    private final int id;
    private String nombre;
    private String email;
    private Rol rol;

    public Usuario(int id, String nombre, String email, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public Rol getRol() { return rol; }

    @Override public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', rol=" + rol + "}";
    }
}
