package Controlador;

import Model.Administrador;

import java.util.List;
import java.util.Scanner;


/*
    05/06/2025: Quem for mexer, terminar o if-else que eu deixei marcado, abraços.
 */
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcaoDoMenu; // Esse int é para escolher quem vai trabalhar. (aluno, professor..)
        char opcaoContinuar; // Confere se deseja continuar ou não.

        List<Administrador> administradors;
        // Este while true faz a aplicação rodar até o usuário decidir parar.
        while (true){

            // Este while true verifica e confirma se o número está dentro dos limites estabelecidos.
            while (true) {
                menu();
                System.out.print("Digite uma opção: ");
                opcaoDoMenu = teclado.nextInt();

                if ((opcaoDoMenu >= 1) && (opcaoDoMenu <= 4)) {
                    break;
                } else {
                    System.out.println("Escolha uma opção válida!");
                }
            }

            /*
                não é nem de longe a melhor maneira de trabalhar com as classes
                mas por hora, é melhor do que criar outras classes controladoras.
             */
            if (opcaoDoMenu == 1){

            } else if (opcaoDoMenu == 2){

            } else if (opcaoDoMenu == 3) {

            } else if (opcaoDoMenu == 4) {

            }
            System.out.print("Deseja continuar? [s/n]: ");
            opcaoContinuar = teclado.next().toLowerCase().charAt(0);

            if (opcaoContinuar == 'n'){
                break;
            }
        }

        teclado.close();
    }

    // Função que mostra o menu
    public static void menu(){
        System.out.println("1 - Administrador ");
        System.out.println("2 - Funcionário ");
        System.out.println("3 - Professor ");
        System.out.println("4 - Aluno ");
    }
}
