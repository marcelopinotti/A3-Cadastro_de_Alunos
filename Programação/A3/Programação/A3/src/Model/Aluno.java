package Agentes;

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
    private List<HistoricoAcademico> historico = new ArrayList<>();
    private List<DocumentoAluno> documentos = new ArrayList<>();

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

    public List<HistoricoAcademico> consultarHistorico() {
        return historico;
    }

    public void anexarDocumento(DocumentoAluno documento) {
        documentos.add(documento);
    }

    public void adicionarNota(Nota nota) {
        notas.add(nota);
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

    public List<HistoricoAcademico> getHistorico() {
        return historico;
    }

    public void setHistorico(List<HistoricoAcademico> historico) {
        this.historico = historico;
    }

    public List<DocumentoAluno> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoAluno> documentos) {
        this.documentos = documentos;
    }
}
