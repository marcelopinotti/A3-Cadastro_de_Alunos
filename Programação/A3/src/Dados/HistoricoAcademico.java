package Dados;

import java.util.Date;

public class HistoricoAcademico {
    private final int historicoID;
    private final Date dataEvento;
    private final String statusEvento;

    public HistoricoAcademico(int historicoID, Date dataEvento, String statusEvento) {
        this.historicoID = historicoID;
        this.dataEvento = dataEvento;
        this.statusEvento = statusEvento;
    }

    public int getHistoricoID() {
        return historicoID;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getStatusEvento() {
        return statusEvento;
    }

}

