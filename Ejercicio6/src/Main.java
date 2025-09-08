import java.util.Random;
import java.util.Scanner;
import models.Ciudad;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tamaño de la Matriz 7 * 4");
        System.out.println("Seleccione:\n1) Generar Datos\n2) Salir");
        int opc = 0;
        while (opc != 1 && opc != 2) {
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
            }else{
                sc.next();
            }
        }

        double[][] datos = new double[7][4];
        if (opc == 1) {
            Random rnd  = new Random();
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 4; j++) {
                    datos[i][j] = -10 + rnd.nextDouble() * 50;
                }
            }
            System.out.println("Temperaturas generadas...");
        }
        else{
            System.exit(0);
        }

        Ciudad ciudad = new Ciudad(datos);
        System.out.println("Temperaturas generadas: ");
        ciudad.imprimirMatriz();

        System.out.println("\nPromedios semanales: ");
        double[] proms = ciudad.obtenerPromediosSemanales();

        for (int i = 0; i < proms.length; i++) {
            System.out.printf("Semana %d -> %.2f C%n", i + 1, proms[i]);
        }

        System.out.printf("%nTemperatura máxima del mes: %.2f C%n", ciudad.temperaturaMaxima());


        System.out.println(ciudad.diaMasFrio());

        // Si quieres también obtener los índices numéricos:
        int[] idx = ciudad.diaMasFrioIdx();
        System.out.printf("Índices (1-based): día=%d, semana=%d%n", idx[0], idx[1]);

        sc.close();
    }
}