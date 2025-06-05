package Agentes;

public abstract class Usuario {
    protected String email;
    protected String senha;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean Autenticar(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public boolean logout() {
        return true;
    }
}



