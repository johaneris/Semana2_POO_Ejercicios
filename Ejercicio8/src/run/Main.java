package run;

import models.EstadisticaTexto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Ingrese una frase:");
        String frase = in.nextLine();

        // Dividir por espacios en blanco
        String[] palabras = frase.split("\\s+");

        EstadisticaTexto est = new EstadisticaTexto(palabras);

        System.out.println("Cantidad de palabras: " + est.contarPalabras());
        System.out.println("Palabras únicas: " + est.palabrasUnicas());
        System.out.println("Palabra más larga: " + est.palabraMasLarga());
        System.out.println("Palabra más corta: " + est.palabraMasCorta());

        in.close();
    }
}