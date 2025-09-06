package run;

public class Inventario
{
    private Producto[] productos;
    private int contador;

    public Inventario(int tamano)
    {
        productos = new Producto[tamano];
        contador = 0;
    }

    public boolean anadirProducto(Producto p)
    {
        if (contador < productos.length)
        {
            productos[contador] = p;
            contador++;
            return true;
        }
        else
        {
            System.out.println("Inventario lleno, nose puede agregar mas productos");
            return false;
        }
    }

    public Producto buscarProducto(int codigo)
    {
        for (int i = 0; i < contador; i++)
        {
            if (productos[i].getCodigo() == codigo)
            {
                return productos[i];
            }
        }
        return null;
    }

    public void mostrarProductos(int cant)
    {
        System.out.println("Productos con stock menor a " + cant);
        boolean encontrado = false;
        for (int i = 0; i < contador; i++)
        {
            if (productos[i].getCantidad() < cant)
            {
                System.out.println(productos[i]);
                encontrado = true;
            }
        }
        if (!encontrado)
        {
            System.out.println("No hay productos con stock menor a 5");
        }
    }
}
