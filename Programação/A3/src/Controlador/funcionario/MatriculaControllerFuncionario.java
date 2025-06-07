package Controlador.funcionario;

import Model.Aluno;
import Dados.Curso;
import Model.Funcionario;

import java.util.Scanner;

public class MatriculaControllerFuncionario {

    public static void menuMatricula(Scanner teclado, Funcionario func) {
        int opcao = 0;

        do {
            System.out.println("\n=== MENU MATRÍCULA ===");
            System.out.println("1 - Matricular aluno em curso");
            System.out.println("2 - Ver cursos de um aluno");
            System.out.println("9 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== MATRICULAR ALUNO ===");

                    System.out.print("ID do aluno: ");
                    int idAluno = teclado.nextInt();
                    teclado.nextLine();

                    Aluno aluno = func.listarAluno(idAluno);

                    if (aluno == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.println("Cursos disponíveis:");
                    func.listarCursos();

                    System.out.print("ID do curso: ");
                    int idCurso = teclado.nextInt();
                    teclado.nextLine();

                    func.matricularAlunoEmCurso(aluno, idCurso, func.consultarCursos());
                }

                case 2 -> {
                    System.out.println("=== CURSOS DO ALUNO ===");
                    System.out.print("ID do aluno: ");
                    int idAluno = teclado.nextInt();
                    teclado.nextLine();

                    Aluno aluno = func.listarAluno(idAluno);

                    if (aluno != null) {
                        System.out.println("Cursos em que o aluno está matriculado:");
                        if (aluno.getCursos().isEmpty()) {
                            System.out.println("Nenhum curso matriculado.");
                        } else {
                            for (Curso curso : aluno.getCursos()) {
                                System.out.println("ID: " + curso.getCursoID()
                                        + ", Nome: " + curso.getNome()
                                        + ", Categoria: " + curso.getCategoria()
                                        + ", Duração: " + curso.getDuracao()
                                        + ", Status: " + curso.getStatusCurso());
                            }
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }

                case 0 -> System.out.println("Voltando ao menu do funcionário...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }
}

