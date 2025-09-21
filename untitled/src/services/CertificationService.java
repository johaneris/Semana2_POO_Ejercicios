package services;

import dao.Ids;
import enums.EstadoCertificado;
import models.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CertificationService {

    public double calcularPorcentajeAsistencia(Inscripcion ins) {
        Evento evento = ins.getEvento();
        int total = evento.getSesiones().size();
        if (total == 0) return 0;

        Set<Integer> asistidas = new HashSet<>();
        for (CheckIn ci : ins.getCredencial().getCheckIns()) {
            if (ci.getSesion() != null) {
                asistidas.add(ci.getSesion().getId());
            }
        }
        return asistidas.size() / (double) total;
    }

    public Certificado emitirSiElegible(Inscripcion ins) {
        double porc = calcularPorcentajeAsistencia(ins);
        double umbral = ins.getEvento().getReglaCertificado().getPorcentajeMinimo();
        EstadoCertificado estado = (porc >= umbral) ? EstadoCertificado.VALIDO
                : EstadoCertificado.NO_ELEGIBLE;

        return new Certificado(
                Ids.next(),
                ins.getUsuario(),
                ins.getEvento(),
                "https://certs.local/c/" + ins.getUsuario().getId() + "/" + ins.getEvento().getId(),
                LocalDate.now(),
                estado
        );
    }
}
