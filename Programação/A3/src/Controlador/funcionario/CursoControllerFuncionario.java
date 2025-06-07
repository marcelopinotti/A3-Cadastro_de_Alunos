package Controlador.funcionario;


import Model.Funcionario;



import java.util.Scanner;

public class CursoControllerFuncionario {

    public static void menuCurso(Scanner teclado, Funcionario func) {
        int opcao = 0;
        
        do {
            System.out.println("\n=== MENU CURSOS ===");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Listar cursos");
            System.out.println("3 - Atualizar curso");
            System.out.println("4 - Excluir curso");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();  //limpa buffer (sim, eu sempre esqueco o que isso faz)

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== CADASTRAR CURSO ===");
                    System.out.println("ID do curso: ");
                    int idCurso = teclado.nextInt();
                    teclado.nextLine(); //limpa buffer
                    System.out.println("Nome do curso: ");
                    String nomeCurso = teclado.nextLine();
                    System.out.println ("Categoria do curso: ");
                    String categoriaCurso = teclado.nextLine();
                    System.out.println("Duração (em horas): ");
                    int duracaoCurso = teclado.nextInt();
                    teclado.nextLine(); //limpa buffer
                    System.out.println("Status do curso (ativo/inativo): ");
                    String statusCurso = teclado.nextLine();

                    func.cadastrarCurso(idCurso, nomeCurso, categoriaCurso, duracaoCurso, statusCurso);
                    System.out.println("Curso cadastrado com sucesso!");
                }

                case 2 -> {
                    System.out.println("=== LISTAR CURSOS ===");
                    func.listarCursos(); //isso aqui ja lista os cursos cadastrados
                }

                case 3 -> {
                    System.out.println("=== ATUALIZAR CURSO ===");
                    System.out.print("ID do curso: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Nova categoria: ");
                    String categoria = teclado.nextLine();

                    System.out.print("Nova duração (em horas): ");
                    int duracao = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Novo status (ativo/inativo): ");
                    String status = teclado.nextLine();

                    func.atualizarCurso(id, nome, categoria, duracao, status);
                }

                case 4 -> {
                    System.out.println("=== EXCLUIR CURSO ===");
                    System.out.print("ID do curso: ");
                    int id = teclado.nextInt();
                    teclado.nextLine();

                    func.excluirCurso(id);
                }

                case 0 -> {
                    System.out.println("Voltando ao menu do funcionário...");
                }

                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
            }
        }


