package Condicoes;

public class ifEElse {
    static void main(String[] args) {
        /*Ninja Naruto*/
        String nome = "Naruto";
        String rank;

        int idade = 17;
        boolean hokage = false;
        short numeroDeMissoes = 20;


        if (numeroDeMissoes >= 10 && idade <= 17){
            System.out.println("Rank: Chunnin");
        } else if (numeroDeMissoes >= 20 && idade >= 18) {
            System.out.println("Rank: Jounin");
        } else {
            System.out.println("Rank: Gennim");
        }

    }
}
