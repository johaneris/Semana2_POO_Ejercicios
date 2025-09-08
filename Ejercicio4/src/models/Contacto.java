package models;

//    4. Agenda de Contactos
//    Objetivo: Clase Contacto con nombre, teléfono, correo (todo String). Usa un arreglo para guardar contactos.
//            •    Permite añadir, buscar por nombre, y mostrar todos.
//            •    Método para buscar por dominio del correo (@gmail.com, etc).

public class Contacto {


    private String  nombre;
    private String telefono;
    private String correo;

    //constructores
    public Contacto() {
    }

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }
    //valdiar entrada
    public void setCorreo(String correo) {

//        int longitud = correo.length();
        if(correo.endsWith("@gmail.com")){
            this.correo = correo;
        }
    }
}
