package run;

import models.Estudiante;

public class Main {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[5];

        estudiantes[0] = new Estudiante("Valeria", 18, new double[]{90.5, 100, 88.4, 96.7});
        estudiantes[1] = new Estudiante("Manuel", 19, new double[]{91, 83, 78, 100});
        estudiantes[2] = new Estudiante("Johaneris", 18, new double[]{100, 100, 95.8, 83.3});
        estudiantes[3] = new Estudiante("Steven", 18, new double[]{80, 100, 96.3, 98.7});
        estudiantes[4] = new Estudiante("Gabriel", 19, new double[]{0, 10, 50, 80, 90});

        // Metodo para mostrar a los alumnos con mejor promedio
        System.out.println("\nEstudiantes con mejor promedio: ");
        for (Estudiante estudiante : estudiantes) { // recorrer el arreglo
            if (estudiante.CalcularPromedio() > 80.0) {
                estudiante.MostrarDatos();
            }
        }
    }
}