package models;

import java.util.HashSet;
import java.util.Set;

public class EstadisticaTexto {
    private String[] palabras;

    // Constructor
    public EstadisticaTexto(String[] palabras) {
        this.palabras = palabras;
    }

    // Contar palabras
    public int contarPalabras() {
        return palabras.length;
    }

    // Mostrar palabras únicas
    public Set<String> palabrasUnicas() {
        Set<String> unicas = new HashSet<>();
        for (String palabra : palabras) {
            unicas.add(palabra.toLowerCase()); // evita duplicados por mayúsculas
        }
        return unicas;
    }

    // Palabra más larga
    public String palabraMasLarga() {
        String larga = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() > larga.length()) {
                larga = palabra;
            }
        }
        return larga;
    }

    // Palabra más corta
    public String palabraMasCorta() {
        String corta = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() < corta.length()) {
                corta = palabra;
            }
        }
        return corta;
    }
}
