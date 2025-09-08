package models;

public class Ciudad {
    public static int Days = 7;
    public static int Weeks = 4;

    private double[][] temperaturas;

    public Ciudad(double[][] temperaturas) {
        if (temperaturas == null || temperaturas.length != Days) {
            throw new IllegalArgumentException(String.format("La matriz debe tener %s filas (dias)", Days));
        }
        for (double[] fila: temperaturas){
            if (fila == null || fila.length != Weeks){
                throw new IllegalArgumentException(String.format("La matriz debe tener %s columnas (semanas)", Weeks));
            }
        }
        this.temperaturas = new double[Days][Weeks];
        for (int i = 0; i < Days; i++){
            System.arraycopy(temperaturas[i], 0, this.temperaturas[i], 0, Weeks);
        }
    }

    public double promedioSemanal(int selected_week) {
        int week_base = selected_week - 1;
        if (week_base < 0 || week_base >= Weeks){
            throw new IllegalArgumentException("Semana fuera de rango");
        }
        double total = 0;
        for (int i = 0;i<Days;i++){
            total += temperaturas[i][week_base];
        }
        return total/Days;
    }

    public double[] obtenerPromediosSemanales(){
        double[] promedios = new double[Weeks];
        for (int i = 0; i < Weeks; i++){
            promedios[i] = promedioSemanal(i+1);
        }
        return promedios;
    }

    public double temperaturaMaxima(){
        double max = temperaturas[0][0];
        for (int i =0; i<Days; i++){
            for (int j = 0; j<Weeks; j++){
                if (temperaturas[i][j] > max){
                    max = temperaturas[i][j];
                }
            }
        }
        return max;
    }

    public int[] diaMasFrioIdx(){
        int diaMin = 0;
        int semanaMin = 0;
        double min = temperaturas[0][0];
        for (int i = 1; i<Days; i++){
            for (int j = 0; j<Weeks; j++){
                if (temperaturas[i][j] < min){
                    min = temperaturas[i][j];
                    diaMin = i;
                    semanaMin = j;
                }
            }
        }
        return new int[]{diaMin,semanaMin};
    }

    public String diaMasFrio(){
        int[] idx = diaMasFrioIdx();
        double temp=temperaturas[idx[0]][idx[1]];
        return String.format("Dia mas frio es:\nDia %d\nSemana %d\n%.2f C", idx[0], idx[1],temp);
    }

    public void imprimirMatriz(){
        String[] nombreDias = {"Lun", "Mar", "Mier", "Jue", "Vier", "Sab", "Dom"};
        for (int i = 0; i < Weeks; i++){
            System.out.printf("Sem%d ", i+1);
        }
        System.out.println();
        for (int i = 0; i < Days; i++){
            System.out.printf("%s ", nombreDias[i]);
            for (int j = 0; j < Weeks; j++){
                System.out.printf("%.2f ", temperaturas[i][j]);
            }
            System.out.println();
        }
    }
}
