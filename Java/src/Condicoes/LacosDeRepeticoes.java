package Condicoes;

import java.util.Scanner;

public class LacosDeRepeticoes {
    static void main(String[] args) {
        Scanner caixaDeTexto = new Scanner(System.in);
        int numeroDeclones = 0;
        int numeroMaximoDeClones = 40;

      /*  while (numeroDeclones <= numeroMaximoDeClones){
            numeroDeclones++;
            System.out.println("O Naruto fez um clone das sombras " + numeroDeclones);
        }*/
        for (int i = 0; i <= numeroMaximoDeClones ; i++) {
            System.out.println("O Naruto esta se clonando e ja se clonou " + i);
        }

    }
}
