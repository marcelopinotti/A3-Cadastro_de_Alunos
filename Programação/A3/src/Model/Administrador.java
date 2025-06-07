package Model;

import java.util.List;


// Fiz mais um metodo, listando o menu da classe, lembrar de adicionar isso.

public class Administrador extends Funcionario {
    public Administrador(int funcId, String nome, String cargo, String email, String senha) {
        super(funcId, nome, cargo, email, senha);
    }

    List<Funcionario> funcionarios;

    public List<Funcionario> cadastrarFuncionario(java.util.List<Funcionario> funcionarios, int funcId, String nome, String cargo, String email, String senha) {
        Funcionario novoFuncionario = new Funcionario(funcId, nome, cargo, email, senha);
        funcionarios.add(novoFuncionario);
        return funcionarios;
    }

    public List<Funcionario> consultarFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getFuncId() + ", Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo());
        }
        return funcionarios;
    }

    public boolean alterarFuncionario(List<Funcionario> funcionarios, int funcId, String nome, String cargo, String email, String senha) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getFuncId() == funcId) {
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setEmail(email);
                funcionario.setSenha(senha);
                return true;
            }
        }
        return false;
    }

    public boolean alterarStatusFuncionario(List<Funcionario> funcionarios, int funcId, String status) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getFuncId() == funcId) {
                funcionario.setStatus(status);
                return true;
            }
        }
        return false;
    }
    public boolean removerFuncionario(List<Funcionario> funcionarios, int funcId) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getFuncId() == funcId) {
                funcionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }


    public void menu(){
        System.out.println("1 - Cadastrar novo funcionário: ");
        System.out.println("2 - Consultar funcionários: ");
        System.out.println("3 - Atualizar dados de funcionários: ");
        System.out.println("4 - Excluir funcionário: ");
    }
}

