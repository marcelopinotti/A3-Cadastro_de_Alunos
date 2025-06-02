package Dados;

public class Curso {
    private final int cursoID;
    private String nome;
    private String categoria;
    private int duracao;
    private String status;

    public Curso(int cursoID, String nome, String categoria, int duracao, String status) {
        this.cursoID = cursoID;
        this.nome = nome;
        this.categoria = categoria;
        this.duracao = duracao;
        this.status = status;
    }

    public int getCursoID() {
        return cursoID;
    }
    public String getNome() {
        return nome;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getDuracao() {
        return duracao;
    }
    public String getStatusCurso() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public void setStatusCurso(String status) {
        this.status = status;
    }
}

