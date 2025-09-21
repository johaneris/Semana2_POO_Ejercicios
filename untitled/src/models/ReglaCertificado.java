package models;

public class ReglaCertificado {
    private final double porcentajeMinimo; // 0..1

    public ReglaCertificado(double porcentajeMinimo) {
        if (porcentajeMinimo < 0 || porcentajeMinimo > 1) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 1");
        }
        this.porcentajeMinimo = porcentajeMinimo;
    }

    public double getPorcentajeMinimo() { return porcentajeMinimo; }
}
