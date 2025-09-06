package run;

public class Producto
{
    private String nombre;
    private int codigo;
    private int cantidad;

    public Producto(String nombre, int codigo, int cantidad)
    {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", cantidad=" + cantidad +
                '}';
    }
}
