package Controlador.funcionario;

import Model.Aluno;
import Model.Funcionario;

import java.util.Scanner;

//controller responsável pelo submenu de gerenciamento de alunos do funcionário
public class AlunoControllerFuncionario {

    public static void menuAluno(Scanner teclado, Funcionario func) {
        int opcao = 0;
        do {
            System.out.println("\n=== MENU ALUNOS ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Consultar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); //limpa buffer



            switch (opcao) {
                case 1 -> {
                    System.out.println("=== CADASTRAR ALUNO ===");
                    System.out.print("ID: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = teclado.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = teclado.nextLine();
                    System.out.print("Email: ");
                    String email = teclado.nextLine();
                    System.out.print("Senha: ");
                    String senha = teclado.nextLine();

                    func.cadastrarAluno(email, senha, id, nome, cpf, telefone, endereco);
                    System.out.println("Aluno cadastrado com sucesso!");
                }

                case 2 -> {
                    System.out.println("=== CONSULTAR ALUNOS ===");
                    System.out.print("ID: ");
                    int id = teclado.nextInt();
                    Aluno aluno = func.listarAluno(id);
                    if (aluno != null) {
                    System.out.println("ID " + aluno.getAlunoID());
                    System.out.println("Nome: " + aluno.getNome());
                    System.out.println("CPF: " + aluno.getCpf());
                    System.out.println("Telefone: " + aluno.getTelefone());
                    System.out.println("Endereço: " + aluno.getEndereco());
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                
                case 3 -> {
                    System.out.println("=== ATUALIZAR ALUNO ===");
                    System.out.print("ID do aluno a ser atualizado: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Novo Email: ");
                    String email = teclado.nextLine();          //incluo atualizar senha tambem?
                    System.out.println("Novo telefone: ");
                    String telefone = teclado.nextLine();
                    System.out.println("Novo endereço: ");
                    String endereco = teclado.nextLine();

                    func.atualizarDados(id, telefone, endereco, email);
                    System.out.println("Aluno atualizado com sucesso!");
                }

                case 4 -> {
                    System.out.println("=== EXCLUIR ALUNO ===");
                    System.out.print("ID do aluno a ser excluído: ");
                    int id = teclado.nextInt();
                    
                    func.excluirAluno(id);
                }
                
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
            
    }

}
