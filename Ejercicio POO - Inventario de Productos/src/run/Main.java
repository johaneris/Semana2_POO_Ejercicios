package run;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Inventario inventario = new Inventario(10);

        inventario.anadirProducto(new Producto("Manzana", 001, 10));
        inventario.anadirProducto(new Producto("Naranjas", 002, 3));


        while (true)
        {
            System.out.println("1. Agregar producto\n2. Buscar por codigo\n3. Mostrar todo los productos\n4. Salir");
            System.out.println("Digite su opcion: ");
            int opcion = sc.nextInt();
            if (opcion == 1)
            {
                System.out.println("Digite el nombre del producto: ");
                String nom = sc.next();
                System.out.println("Digite el codigo del producto (solo numeros): ");
                int cod =  sc.nextInt();
                System.out.println("Digite la cantidad del producto: ");
                int cant = sc.nextInt();

                inventario.anadirProducto(new Producto(nom,cod,cant));
            }
            if  (opcion == 2)
            {
                System.out.println("Digite el codigo del producto (solo numeros): ");
                Producto pro = inventario.buscarProducto(sc.nextInt());
                if (pro != null)
                {
                    System.out.println("Producto encontrado: " + pro);
                } else
                {
                    System.out.println("Producto no encontrado.");
                }

            }
            if (opcion == 3)
            {
                System.out.println("Digite la cantidad del producto por la cual se va a filtrar (solo numeros): ");
                int cant = sc.nextInt();
                inventario.mostrarProductos(cant);
            }
            if (opcion == 4)
            {
                System.out.println("Adios...");
                break;
            }
            else if (opcion > 4 || opcion < 1)
            {
                System.out.println("Digite una opcion valida");
            }
        }
    }
}
