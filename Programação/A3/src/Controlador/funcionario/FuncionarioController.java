package Controlador.funcionario;                   /*menu principal do funcionario, aqui da pra escolher os
                                            * submenus de aluno, curso, matrícula e relatorio academico*/

import Model.Funcionario;

import java.util.Scanner;

public class FuncionarioController {

    public static void menuFuncionario(Scanner teclado) {
        Funcionario func = new Funcionario(1, "Funcionario padrão", "Funcionário", "func@teste.com", "1234");

        int opcao = 0;
        do {
            System.out.println("\n=== MENU FUNCIONÁRIO ===");
            System.out.println("1 - Gerenciar alunos");
            System.out.println("2 - Gerenciar cursos");
            System.out.println("3 - Relatório acadêmico");
            System.out.println("4 - Matrícula de aluno em curso");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> AlunoControllerFuncionario.menuAluno(teclado, func);
                case 2 -> CursoControllerFuncionario.menuCurso(teclado, func);
                case 3 -> System.out.println(func.relatorioAcademico());
                case 4 -> MatriculaControllerFuncionario.menuMatricula(teclado, func);
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);
    }
} 
