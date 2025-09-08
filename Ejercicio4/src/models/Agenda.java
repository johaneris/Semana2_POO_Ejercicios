package models;

public class Agenda {

    Contacto[] contactos = new Contacto[20];


    public void  guardarDatos(Contacto contacto){

        for(int i=0; i<contactos.length; i++){

            //es para saber si el espacio no esta ocuapdo

            if(contactos[i] == null){
                contactos[i] = contacto;
                //tenemos que retornar solo para guardar uno
                return;
            }
        }
    }

    public void mostrarContactos() {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                System.out.println(contactos[i]);
            }
        }
    }


    public String buscarPorNombre(Contacto contacto){

        if(contacto == null || contacto.getNombre() == null){
            return null;
        }
        for(int i=0; i<contactos.length; i++){
            if(contacto.getNombre().equalsIgnoreCase(contactos[i].getNombre())){
                return "Telefono: " + contactos[i].getTelefono() + " " + "Correo: " +contactos[i].getCorreo();
            }
        }

        return null;
    }

    public String buscarPorDominio(Contacto contacto){

        if(contacto == null || contacto.getCorreo() == null){
            return null;
        }
        for(int i=0; i<contactos.length; i++){
            if(contacto.getCorreo().equalsIgnoreCase(contactos[i].getCorreo())){
                return "Nombre: "+contactos[i].getNombre() + " " + "Telefono: " + contactos[i].getTelefono();
            }
        }

        return null;
    }
}
