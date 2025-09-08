package run;
import java.util.Scanner;

public class Main
{
    public static  void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba su texto: ");
        String entrada = sc.nextLine();
        Cadena c = new Cadena(entrada);

        while (true)
        {
            System.out.println("\n1. Escribir Oracion\n2. Convertir a Mayusculas\n3. Convertir a Minusculas\n4. Invertir Oracion\n5. Es palindromo?\n6. Conteo de Consonantes y Vocales\n7. Salir");
            System.out.println("Digite su opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("");

            if (opcion == 1)
            {
                System.out.println("Escriba su oracion: ");
                String txt = sc.nextLine();
                c.setTexto(txt);
            }
            if (opcion == 2)
            {
                System.out.println("Oracion en Mayusculas: " + c.aMayus());
            }
            if (opcion == 3)
            {
                System.out.println("Oracion en Minusculas: " + c.aMinus());
            }
            if (opcion == 4)
            {
                System.out.println("Oracion invertida: "+ c.invertir());
            }
            if (opcion == 5)
            {
                System.out.println("Es palindromo?: " + (c.esPalindromo() ? "Si" : "No"));
            }
            if (opcion == 6)
            {
                int[] conteo = c.contarVocalesConsonantes();
                System.out.println("Vocales: " + conteo[0]);
                System.out.println("Consonantes: " + conteo[1]);
            }
            if (opcion == 7)
            {
                break;
            }
            else if (opcion < 1 || opcion > 7)
            {
                System.out.println("Digite una opcion valida");
            }
        }
    }
}
