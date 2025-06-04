package Agentes;

import java.util.ArrayList;
import java.util.List;
import Dados.*;

/*

Únicos métodos necessários:

    Autenticar // Isso já é feito na classe usuário
    Atualizar Dados ok
    Consultar Histórico ok
    Consultar Nota ok


    Como Documento até o dia de hoje [04/06/25] não é necessário, está "comentado".
 */


public class Aluno extends Usuario {

    // Métodos
    private final int alunoID;
    private String nome;
    private final String cpf;
    private String telefone;
    private String endereco;

    private List<Nota> notas = new ArrayList<>();
    private List<HistoricoAcademico> historico = new ArrayList<>();
    // private List<DocumentoAluno> documentos = new ArrayList<>();

    // Construtores

    public Aluno(int alunoID, String nome, String cpf, String email, String telefone, String endereco, String senha) {
        super(email, senha);
        this.alunoID = alunoID;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Atualiza os dados
    public void atualizarDados(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Retorna as notas
    public List<Nota> consultarNotas() {
        return notas;
    }

    // Retorna o histórico Acadêmico
    public List<HistoricoAcademico> consultarHistorico() {
        return historico;
    }

    // public void anexarDocumento(DocumentoAluno documento) {
    //     documentos.add(documento);
    // }

    // pede a nota no controller.
    public void adicionarNota(Nota nota) {
        notas.add(nota);
    }

    // getter do id
    public int getAlunoID() {
        return alunoID;
    }

    // getter
    public String getNome() {
        return nome;
    }

    // setter do nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // getter do cpf
    public String getCpf() {
        return cpf;
    }

    // getter telefone
    public String getTelefone() {
        return telefone;
    }

    // setter telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // getter endereço
    public String getEndereco() {
        return endereco;
    }

    // setter endereço
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // getter do notas. OBS: Ver como isso aqui vai funcionar
    public List<Nota> getNotas() {
        return notas;
    }

    // setter do notas. OBS: Ver como isso aqui vai funcionar
    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    // getter historico
    public List<HistoricoAcademico> getHistorico() {
        return historico;
    }

    // setter historico
    public void setHistorico(List<HistoricoAcademico> historico) {
        this.historico = historico;
    }

    // public List<DocumentoAluno> getDocumentos() {
    //     return documentos;
    // }

    // public void setDocumentos(List<DocumentoAluno> documentos) {
    //     this.documentos = documentos;
    // }
}
