package Contabilidade;

import java.util.Scanner;

public class cadastroContas {
    public static void main(String[] args) {
        Scanner cdt = new Scanner(System.in);

        int MAXCODIGOCONTABEL = 15;

        String[] codigo = new String[15];
        String[] descricao = new String[15];

        int cadastrados = 0;
        int opcao = 0;


        while(opcao < 4){
            System.out.println(" ======== Escolha uma opção ======== ");
            System.out.println("1. Cadastrar nova conta contábil");
            System.out.println("2. Listar contas cadastradas");
            System.out.println("3. Busca conta pelo código");
            System.out.println("4. Sair");
            opcao = cdt.nextInt();
            cdt.nextLine();

            switch (opcao) {
                case 1:
                    
                    if (cadastrados < MAXCODIGOCONTABEL) {
                        System.out.println("\n=== Menu de cadastro de contas ===");
                        System.out.print("Digite o código da conta (ex: 1.1.1.01): ");
                        String novoCodigo = cdt.nextLine();

                        System.out.print("Digite a descrição da conta: ");
                        String novaDescricao = cdt.nextLine();

                        codigo[cadastrados] = novoCodigo;
                        descricao[cadastrados] = novaDescricao;
                        cadastrados++;

                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("Você chegou no limite de contas cadastradas.");
                    }
                    break;

                case 2: if(cadastrados == 0){
                    System.out.println("Você tem não tem contas cadastradas no momento.");      
                    
                } else{
                    System.out.println("Menu de lista de contas contabéis cadastradas");
                    for (int i = 0; i < cadastrados; i++) {
                        System.out.println("=================");
                        System.out.println("Código: " + codigo[i]);
                        System.out.println("Decrição: " + descricao[i]);
                        System.out.println("Conta Cadastrada");
                    }
                     System.out.println("=================");

                } break;
                case 3: 
                     if (cadastrados == 0) {
                        System.out.println("Não há contas para buscar.");
                    } else {
                        System.out.println("\n=== Menu de busca ===");
                        System.out.print("Digite o código que deseja buscar: ");
                        String buscaCodigo = cdt.nextLine();

                        boolean encontrado = false;

                        for (int i = 0; i < cadastrados; i++) {
                            if (codigo[i].equals(buscaCodigo)) {
                                System.out.println("\nConta encontrada!");
                                System.out.println("Código: " + codigo[i]);
                                System.out.println("Descrição: " + descricao[i]);
                                encontrado = true;
                                break; 
                            }
                        }

                        if (!encontrado) {
                            System.out.println("Nenhuma conta encontrada com esse código.");
                        }
                    }
                    break;
            }
            
        }

        cdt.close();
    }

}

/*Desafio 3 – Balancete Super Simplificado
Ideia: Simular um balancete com pouquinhas contas:
•	Conta 1: Caixa
•	Conta 2: Fornecedores
•	Conta 3: Capital Social
Regras:
•	Ter arrays para:
o	código da conta (int[] codigos = {1, 2, 3};)
o	nome da conta (String[] nomes = {"Caixa", "Fornecedores", "Capital Social"};)
o	saldo da conta (double[] saldos = new double[3];)
Menu sugerido:
1.	Lançar movimentação em uma conta
o	Perguntar: código da conta (1, 2 ou 3)
o	Perguntar: valor (positivo para aumento, negativo para redução)
o	Atualizar o saldo da conta correspondente.
2.	Mostrar balancete
o	Listar todas as contas com seus saldos.
3.	Sair*/
