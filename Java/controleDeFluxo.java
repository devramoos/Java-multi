package Contabilidade;
import java.util.Scanner;

public class controleDeFluxo{
    public static void main(String[] args) {
    Scanner cdt = new Scanner(System.in);

    int MAXLANCAMENTOS = 5;

    String[] descricao = new String[5];
    String[] tipoLancamento = new String[5];
    double[] valorLancamento = new double[5];
    int lancamentoTotais = 0;

    int opcao = 0;

    while(opcao != 4){
        System.out.println("\n====== Menu de opções, faça sua escolha ======");
        System.out.println("1 .Registrar novo lançamento");
        System.out.println("2. Listar lançamentos");
        System.out.println("3. Mostrar total de receitas, despesas e saldo");
        System.out.println("4. Sair");  
        opcao = cdt.nextInt();
        cdt.nextLine();
        
        switch (opcao) {
            case 1:
                if (lancamentoTotais < MAXLANCAMENTOS) {
                    System.out.println("\n ======== Menu de novo lançamentos ========");
                    System.out.println("\nDigite a descrição do lançamento: ");
                    String novaDescricao = cdt.nextLine();

                    System.out.println("Digite o tipo (Receita ou Despesas): ");
                    String novoTipo = cdt.nextLine();

                    System.out.println("Digite o valor do lançamento: ");
                    double novoValor = cdt.nextDouble();
                    cdt.nextLine();

                    descricao[lancamentoTotais] = novaDescricao;
                    tipoLancamento[lancamentoTotais] = novoTipo;
                    valorLancamento[lancamentoTotais] = novoValor;
                    lancamentoTotais++;

                    System.out.println("Você registrou um novo lançamento.");

                } else{
                    System.out.println("Você ultrapassou o limite de lançamentos.");
                }
            break;
                
            case 2:
                if (lancamentoTotais == 0) {
                        System.out.println("Nenhum lançamento encontrado.");
                } else{
                        System.out.println("Menu de lista de lançamentos");
                for (int i = 0; i < lancamentoTotais; i++) {
                    System.out.println("\n==============================");
                    System.out.println("Descrição de Lançamento: " + descricao[i]);
                    System.out.println("Descrição do tipo: " + tipoLancamento[i]);
                    System.out.println("Descrição do valor: " + valorLancamento[i]);
                    System.out.println("==============================");
                    }
                }
            break;

            case 3:
                if (lancamentoTotais == 0) {
                    System.out.println("Nenhum lançamento encontrado.");
                }else{
                    double totalReceita = 0.0;
                    double totalDespesas = 0.0;                  

                    for (int i = 0; i < lancamentoTotais; i++) {
                        if (tipoLancamento[i].equalsIgnoreCase("Despesas")) {
                            totalDespesas += valorLancamento[i];
                        } else if (tipoLancamento[i].equalsIgnoreCase("Receita")) {
                            totalReceita += valorLancamento[i];
                        }
                    }
                    
                    double saldo = totalReceita - totalDespesas;

                    System.out.println("\n ======= Menu de lançamentos =======");
                    System.out.println("\nVocê tem de Receita: " + totalReceita);
                    System.out.println("Você tem de Despesas: " + totalDespesas);
                    System.out.println("Seu saldo atual é: " + saldo);
                }
                
            break;

            case 4:
                System.out.println("Você está saindo do sistema.");
            break;

        }
    
    }



    cdt.close();    
    }
    
}