package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Credencial {
    private final int id;
    private final String codigoQR;
    private final LocalDate fechaEmision;
    private final List<CheckIn> checkIns = new ArrayList<>();

    public Credencial(int id, String codigoQR, LocalDate fechaEmision) {
        this.id = id;
        this.codigoQR = codigoQR;
        this.fechaEmision = fechaEmision;
    }

    public int getId() { return id; }
    public String getCodigoQR() { return codigoQR; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public List<CheckIn> getCheckIns() { return checkIns; }

    public void addCheckIn(CheckIn c) { checkIns.add(c); }
}
