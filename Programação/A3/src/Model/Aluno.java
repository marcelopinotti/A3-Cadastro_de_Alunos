package Model;

import java.util.ArrayList;
import java.util.List;
import Dados.*;

public class Aluno extends Usuario {


    private final int alunoID;
    private String nome;
    private final String cpf;
    private String telefone;
    private String endereco;

    private List<Nota> notas = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();



    public Aluno(int alunoID, String nome, String cpf, String email, String telefone, String endereco, String senha) {
        super(email, senha);
        this.alunoID = alunoID;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public void atualizarDados(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public List<Nota> consultarNotas() {
        return notas;
    }





    public int getAlunoID() {
        return alunoID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Curso> setCursos(List<Curso> cursos) {
        this.cursos = cursos;
        return this.cursos;
    }

    public String consultarNota(List<Nota> notas) {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
        } else {
            for (Nota nota : notas) {
                System.out.println("Nota ID: " + nota.getNotaID() + ", Valor: "
                        + nota.getValorNota() + "," +
                        " Data de Lançamento: " + nota.getDataLancamento());
            }
        } return notas.toString();
    }

}
