package models;

import java.util.Arrays;

public class Estudiante {
    String nombre;
    int edad;
    double[] notas;

    // Constructor
    public Estudiante(String nombre, int edad, double[] notas) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    // Metodo para calcular el promedio
    public double CalcularPromedio() {
        double suma = 0;
        for (int i = 0; i < notas.length; i++) { // .length: tamaño del array
            suma += notas[i];
        }
        return suma/notas.length;
    }

    // Metodo para mostrar los datos
    public void MostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Promedio: " + CalcularPromedio());
        System.out.println("-------------------------");
    }
}

