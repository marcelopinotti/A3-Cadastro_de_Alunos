package Model;

public abstract class Usuario {

    protected String email;
    protected String senha;

    protected Usuario(){
    }

    protected String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    protected String getSenha() {
        return senha;
    }

    protected void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean Autenticar(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean logout() {
        return true;
    }
}



