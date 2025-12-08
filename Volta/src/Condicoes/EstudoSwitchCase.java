package Condicoes;
import java.sql.SQLOutput;
import java.util.Scanner;

public class EstudoSwitchCase {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um personagem: ");
        System.out.println("1 - Naruto Uzumaki");
        System.out.println("2 - Sasuke Uchiha");
        System.out.println("3 - Sakura Haruno");

        int escolhaDoUsuario = scanner.nextInt();

        System.out.println("Voce digitou o numero: " + escolhaDoUsuario);

        switch (escolhaDoUsuario){
            case 1:
                System.out.println("O usuario escolheu o Naruto Uzumaki");
                break;
            case 2:
                System.out.println("O usuario escolheu o Sasuke Uchiha o ninja mais revoltado");
                break;
            case 3:
                System.out.println("O usuario escolheu o Sakura Haruno mais chata");
                break;
            default:
                System.out.println("Voce não digitou uma resposta valida! Tente denovo");
        }

        scanner.close();
    }
}
