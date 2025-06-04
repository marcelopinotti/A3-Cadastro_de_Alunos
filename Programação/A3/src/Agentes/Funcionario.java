package Agentes;

import java.util.List;

public class Funcionario {

    // --- atributos ---
    private int funcId;
    private String nome;
    private String cargo;
    private String logIn;
    private String senha;


    List<Aluno> alunos; // Utiliza a agregação para instanciar o objeto Aluno dentro da classe.

    // --- construtores ---

    public Funcionario(){
    }

    public Funcionario(int funcId, String nome, String cargo, String logIn, String senha) {
        this.funcId = funcId;
        this.nome = nome;
        this.cargo = cargo;
        this.logIn = logIn;
        this.senha = senha;
    }

    // --- getters e setters ---
    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // --- metodos ---

    // autentica os dados de LogIn
    public boolean Autenticar(String logIn, String senha) {
        return this.logIn.equals(logIn) && this.senha.equals(senha);
    }

    // cadastra um novo aluno.
    public Aluno cadastrar(String email, String senha, int id, String nome, String cpf, String telefone, String endereco) {
        Aluno novoAluno = new Aluno(id, nome, cpf, email, telefone, endereco, senha);
        alunos.add(novoAluno);
        return novoAluno;
    }



}
