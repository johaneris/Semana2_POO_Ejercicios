package run;

import models.Libros;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Libros[] libros = new Libros[5];

        libros[0] = new Libros("Cien años de soledad", "Gabriel Garcia Marquez", 1967);
        libros[1] = new Libros("El código Da Vinci", "Dan Brown", 2003);
        libros[2] = new Libros("Los juegos del hambre", "Suzanne Collins", 2008);
        libros[3] = new Libros("Suzanne Collins", "Carlos Ruiz Zafón", 2001);
        libros[4] = new Libros("La chica del tren", "Paula Hawkins", 2015);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nGestor de libros\n");
            System.out.println("1. Filtrar por título");
            System.out.println("2. Filtrar por año");
            System.out.println("3. Mostrar libros publicados después del 2010");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // <- limpia el salto de línea pendiente antes de pedir Strings

            if (opcion == 1) {
                System.out.print("Ingrese el nombre del libro que desea buscar: ");
                String nombre = sc.nextLine().trim();

                boolean found = false;

                for (int i = 0; i < libros.length; i++) {
                    if (libros[i].getTitulo().trim().equalsIgnoreCase(nombre)) {
                        System.out.println("Libro encontrado: " + libros[i].getTitulo());
                        found = true;
                        // si quieres listar TODOS los que coincidan, NO hagas break
                        break; // si solo quieres el primero, déjalo
                    }
                }

                if (!found) {
                    System.out.println("Libro no encontrado. Inténtelo de nuevo.");
                }
            }

            if (opcion == 2) {
                System.out.print("Ingrese el año del libro que desea buscar: ");
                int anioBuscado = sc.nextInt();
                sc.nextLine(); // limpia si luego vuelves a pedir Strings

                boolean found = false;

                for (int i = 0; i < libros.length; i++){
                    if (libros[i].getAnio() == anioBuscado){
                        System.out.println("Libro encontrado: " + libros[i].getTitulo() + " (" + libros[i].getAnio() + ")");
                        found = true;
                        // break si solo quieres uno
                    }
                }

                if (!found) {
                    System.out.println("No hay libros del año " + anioBuscado + ".");
                }
            }

            if (opcion == 3) {
                boolean found = false;

                for (int i = 0; i < libros.length; i++){
                    if (libros[i].getAnio() > 2010) {
                        if (!found) {
                            System.out.println("Libros publicados después de 2010:");
                        }
                        System.out.println("- " + libros[i].getTitulo() + " (" + libros[i].getAnio() + ")");
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No hay libros publicados después de 2010.");
                }
            }

            if (opcion == 4) {
                System.out.println("Saliendo...");
                break;
            }
        }

        sc.close();
    }
}
