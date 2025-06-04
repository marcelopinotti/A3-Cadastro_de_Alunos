package Agentes;

public abstract class Usuario {
    protected String email;
    protected String senha;

    public Usuario(){

    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    // função para conferir se o email e senha digitados estão corretos.
    // eu acho que é de mais, verificar se é realmente necessário
    public boolean Autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    // log out, eu acho que é de mais..
    public boolean logout() {
        return true;
    }
}



