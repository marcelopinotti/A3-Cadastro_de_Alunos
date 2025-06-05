package Dados;

import java.time.LocalDate;


public class Nota {
    private final int notaID;
    private double valorNota;
    private final LocalDate dataLancamento;
    private final int cursoID;

    public Nota(int notaID, double valorNota, LocalDate dataLancamento, int cursoID) {
        this.notaID = notaID;
        this.valorNota = valorNota;
        this.dataLancamento = dataLancamento;
        this.cursoID = cursoID;
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


    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public int getCursoID() {
        return cursoID;
    }
}






