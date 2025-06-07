package Controlador.aluno;

import Model.Aluno;
import Dados.Curso;
import Dados.Nota;

import java.util.List;
import java.util.Scanner;

public class AlunoController {

    public static void menuAluno(Scanner teclado, Aluno aluno) {
        int opcao = 0;

        do {
            System.out.println("\n=== MENU DO ALUNO ===");
            System.out.println("1 - Consultar dados pessoais");
            System.out.println("2 - Atualizar dados");
            System.out.println("3 - Ver cursos matriculados");
            System.out.println("4 - Ver notas");
            System.out.println("9 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.println("=== DADOS PESSOAIS ===");
                    System.out.println("ID: " + aluno.getAlunoID());
                    System.out.println("Nome: " + aluno.getNome());
                    System.out.println("CPF: " + aluno.getCpf());
                    System.out.println("Telefone: " + aluno.getTelefone());
                    System.out.println("Endereço: " + aluno.getEndereco());
                }

                case 2 -> {
                    System.out.println("=== ATUALIZAR DADOS ===");
                    System.out.print("Novo telefone: ");
                    String telefone = teclado.nextLine();

                    System.out.print("Novo endereço: ");
                    String endereco = teclado.nextLine();

                    aluno.atualizarDados(aluno.getNome(), telefone, endereco);
                    System.out.println("Dados atualizados com sucesso!");
                }

                case 3 -> {
                    System.out.println("=== CURSOS MATRICULADOS ===");
                    List<Curso> cursos = aluno.getCursos();
                    if (cursos.size() == 0) {
                        System.out.println("Nenhum curso matriculado.");
                    } else {
                        for (Curso curso : cursos) {
                            System.out.println(curso.getNome());
                        }
                    }
                }

                case 4 -> {
                    System.out.println("=== NOTAS ===");
                    List<Nota> notas = aluno.consultarNotas();
                    aluno.consultarNota(notas);
                }

                case 0 -> System.out.println("Voltando ao menu principal...");

                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }
} 
