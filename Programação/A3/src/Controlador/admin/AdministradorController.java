package Controlador.admin;
/*Controller do Administrador*/ 

import Model.Administrador;
import Model.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdministradorController {
    static List<Administrador> administradores = new ArrayList<>();
    static List<Funcionario> funcionarios = new ArrayList<>();

    public static void menuAdministrador(Scanner teclado) {
        //Criando um adm apenas para chamar os métodos, não é salvo no arraylist//
        Administrador adm = new Administrador(0, "Administrador", "Admin", "admin@teste.com", "1234" );

        int opcao = 0;
        do {
            System.out.println("\n=== MENU ADMINISTRADOR ===");
            adm.menu();  //mostra opções do menu
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); //limpar buffer 

            switch (opcao) {
                case 1: {
                    System.out.println("=== CADASTRAR FUNCIONÁRIO ==="); //solicita dados do funcionário
                    System.out.print("ID: ");
                    int id = teclado.nextInt();
                    teclado.nextLine(); 
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = teclado.nextLine();
                    System.out.print("Email: ");
                    String email = teclado.nextLine();
                    System.out.print("Senha: ");
                    String senha = teclado.nextLine();

                    adm.cadastrarFuncionario(funcionarios, id, nome, cargo, email, senha);
                    System.out.println("Funcionário cadastrado com sucesso!");    
                    break;
                }

                case 2: {
                    System.out.println("=== CONSULTAR FUNCIONÁRIOS ===");
                    adm.consultarFuncionarios(funcionarios);
                    break;
                }

                case 3: {
                    System.out.println("=== ATUALIZAR FUNCIONÁRIO ===");
                    System.out.print("ID do funcionário a ser atualizada: ");
                    int funcId = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = teclado.nextLine();
                    System.out.print("Novo cargo: ");
                    String novoCargo = teclado.nextLine();
                    System.out.print("Novo email: ");
                    String novoEmail = teclado.nextLine();
                    System.out.print("Nova senha: ");
                    String novaSenha = teclado.nextLine();

                    if (adm.alterarFuncionario(funcionarios, funcId, novoNome, novoCargo, novoEmail, novaSenha)) {
                        System.out.println("Funcionário atualizado com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("=== REMOVER FUNCIONÁRIO ===");
                    System.out.println("");
                    System.out.print("ID do funcionário a ser excluído: ");
                    int funcId = teclado.nextInt();

                    if (adm.removerFuncionario(funcionarios, funcId)) {
                        System.out.println("Funcionário removido com sucesso!");
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;
                }

                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);

    }
}


