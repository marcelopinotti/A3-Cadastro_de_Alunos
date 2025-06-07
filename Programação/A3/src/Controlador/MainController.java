package Controlador;    //fiz um update mantendo a estrutura do codigo, mas mostrando um submenu pro funcionario, AINDA NÃO TESTEI TODAS AS FUNÇÕES MAS VDC

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controlador.admin.AdministradorController;                           //esse monte de imports é pq separei os controllers em pastas pra ficar mais organizado
import Controlador.aluno.AlunoController;
import Controlador.funcionario.AlunoControllerFuncionario;                   
import Controlador.funcionario.CursoControllerFuncionario;
import Controlador.funcionario.MatriculaControllerFuncionario;
import Controlador.professor.ProfessorController;

import Model.Administrador;
import Model.Aluno;
import Model.Funcionario;
import Model.Professor;

public class MainController {               //chamei de maincontroller pra manter o padrão 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcaoDoMenu;
        char opcaoContinuar;

        List<Administrador> administradores = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Aluno> alunos = new ArrayList<>();

        Administrador adm = new Administrador(100, "Administrador Padrão", "Administrador", "admin@admin.com", "admin123");      //isso funciona como modelos padrao só pra chamar os métodos, não é salvo no arraylist
        administradores.add(adm);

        Funcionario func = new Funcionario(1, "Funcionario Teste", "Assistente", "func@teste.com", "1234");
        funcionarios.add(func);

        Professor prof = new Professor(1, "Professor Teste");
        professores.add(prof);

        Aluno aluno = new Aluno(1, "Aluno Teste", "111.111.111-11", "aluno@teste.com", "0000", "Rua A", "senha");
        alunos.add(aluno);

        while (true) {
            while (true) {
                menu();
                System.out.print("Digite uma opção: ");
                opcaoDoMenu = teclado.nextInt();
                teclado.nextLine();

                if (opcaoDoMenu >= 1 && opcaoDoMenu <= 4) break;
                else System.out.println("Escolha uma opção válida!");
            }

            if (opcaoDoMenu == 1) {
                AdministradorController.menuAdministrador(teclado);

            } else if (opcaoDoMenu == 2) {
                int opcaoSubmenu;
                do {
                    System.out.println("\n=== SUBMENU FUNCIONÁRIO ===");            //aqui eu criei um submenu pro funcionario, pra deixar mais organizado
                    System.out.println("1 - Gerenciar alunos");
                    System.out.println("2 - Gerenciar cursos");
                    System.out.println("3 - Relatório acadêmico");
                    System.out.println("4 - Matrícula de aluno em curso");
                    System.out.println("0 - Voltar");
                    System.out.print("Escolha uma opção: ");
                    opcaoSubmenu = teclado.nextInt();
                    teclado.nextLine();

                    switch (opcaoSubmenu) {                                                                
                        case 1 -> AlunoControllerFuncionario.menuAluno(teclado, func);
                        case 2 -> CursoControllerFuncionario.menuCurso(teclado, func);
                        case 3 -> System.out.println(func.relatorioAcademico());
                        case 4 -> MatriculaControllerFuncionario.menuMatricula(teclado, func);
                        case 0 -> System.out.println("Voltando ao menu principal...");
                        default -> System.out.println("Opção inválida!");
                    }
                } while (opcaoSubmenu != 0);

            } else if (opcaoDoMenu == 3) {
                ProfessorController.menuProfessor(teclado, prof, alunos);

            } else if (opcaoDoMenu == 4) {
                AlunoController.menuAluno(teclado, aluno);
            }

            System.out.print("Deseja continuar? [s/n]: ");
            opcaoContinuar = teclado.next().toLowerCase().charAt(0);
            if (opcaoContinuar == 'n') break;
        }

        teclado.close();
    }

    public static void menu() {                               //mantive aqui do mesmo jeito q tava
        System.out.println("1 - Administrador");
        System.out.println("2 - Funcionário");
        System.out.println("3 - Professor");
        System.out.println("4 - Aluno");
    }
}
