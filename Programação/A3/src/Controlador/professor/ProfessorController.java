package Controlador.professor;

import Model.Aluno;
import Dados.Nota;
import Model.Professor;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProfessorController {

    public static void menuProfessor(Scanner teclado, Professor professor, List<Aluno> todosAlunos) {
        int opcao = 0;

        do {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1 - Registrar nota");
            System.out.println("2 - Atualizar nota");
            System.out.println("3 - Ver notas de um curso");
            System.out.println("4 - Ver alunos de um curso");
            System.out.println("9 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== REGISTRAR NOTA ===");
                    System.out.print("ID do aluno: ");
                    int idAluno = teclado.nextInt();

                    System.out.print("ID do curso: ");
                    int idCurso = teclado.nextInt();

                    System.out.print("Valor da nota: ");
                    double valor = teclado.nextDouble();
                    teclado.nextLine();

                    LocalDate data = LocalDate.now();
                    professor.registrarNota(idAluno, idCurso, valor, data);
                    System.out.println("Nota registrada com sucesso!");
                }

                case 2 -> {
                    System.out.println("=== ATUALIZAR NOTA ===");
                    System.out.print("ID da nota: ");
                    int idNota = teclado.nextInt();

                    System.out.print("Novo valor da nota: ");
                    double novoValor = teclado.nextDouble();
                    teclado.nextLine();

                    Nota nota = professor.atualizarNota(idNota, novoValor);
                    if (nota != null) {
                        System.out.println("Nota atualizada com sucesso!");
                    } else {
                        System.out.println("Nota não encontrada.");
                    }
                }

                case 3 -> {
                    System.out.println("=== NOTAS DO CURSO ===");
                    System.out.print("ID do curso: ");
                    int idCurso = teclado.nextInt();
                    teclado.nextLine();

                    List<Nota> notas = professor.consultarNotasAlunosEmSeusCursos(idCurso);
                    if (notas.isEmpty()) {
                        System.out.println("Nenhuma nota registrada para este curso.");
                    } else {
                        for (Nota nota : notas) {
                            System.out.println("Nota ID: " + nota.getNotaID()
                                    + " | Curso ID: " + nota.getCursoID()
                                    + " | Valor: " + nota.getValorNota()
                                    + " | Data: " + nota.getDataLancamento());
                        }
                    }
                }

                case 4 -> {
                    System.out.println("=== ALUNOS DO CURSO ===");
                    System.out.print("ID do curso: ");
                    int idCurso = teclado.nextInt();
                    teclado.nextLine();

                    List<Aluno> alunos = professor.consultarListaAlunosEmSeusCursos(idCurso, todosAlunos);
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno matriculado neste curso.");
                    } else {
                        for (Aluno aluno : alunos) {
                            System.out.println("ID: " + aluno.getAlunoID() + " | Nome: " + aluno.getNome());
                        }
                    }
                }

                case 9 -> System.out.println("Voltando ao menu do funcionário...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 9);
    }
}
