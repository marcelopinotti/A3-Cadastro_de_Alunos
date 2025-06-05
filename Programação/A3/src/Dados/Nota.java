package Dados;

import java.util.Date;

public class Nota {
    private final int notaID;
    private double valorNota;
    private final Date dataLancamento;

    public Nota(int notaID, double valorNota, Date dataLancamento) {
     this.notaID = notaID;
     this.valorNota = valorNota;
     this.dataLancamento = dataLancamento;
    }

    public int getNotaID() {
        return notaID;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }


    public Date getDataLancamento() {
        return dataLancamento;
    }
}






