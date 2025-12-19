package Contabilidade;

import java.util.LinkedList;
import java.util.Scanner;

public class sistem {

    private LinkedList<contas> contaContabil = new LinkedList<>();
    private LinkedList<fluxo> movimentacaoExtrato = new LinkedList<>();

    public void cadastrar(Scanner sc) {
        System.out.println("\n--- CADASTRAR ---");
        System.out.println("1 - Conta contabil");
        System.out.println("2 - Movimentacao bancaria");
        System.out.print("Escolha: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op == 1) {
            System.out.print("Codigo: ");
            String codigo = sc.nextLine();

            // evita duplicar codigo
            for (contas c : contaContabil) {
                if (c.getCodigo().equalsIgnoreCase(codigo)) {
                    System.out.println("Ja existe conta com esse codigo.");
                    return;
                }
            }

            System.out.print("Descricao: ");
            String desc = sc.nextLine();
            System.out.print("Grupo contabil: ");
            String grupo = sc.nextLine();

            contaContabil.add(new contas(codigo, desc, grupo));
            System.out.println("Conta cadastrada!");

        } else if (op == 2) {
            System.out.print("Descricao: ");
            String desc = sc.nextLine();
            System.out.print("Grupo: ");
            String grupo = sc.nextLine();
            System.out.print("Valor (ex: 1500.50): ");
            double valor = Double.parseDouble(sc.nextLine().replace(",", "."));

            movimentacaoExtrato.add(new fluxo(desc, grupo, valor));
            System.out.println("Movimentacao cadastrada!");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    public void remover(Scanner sc) {
        System.out.println("\n--- REMOVER ---");
        System.out.println("1 - Remover conta (por codigo)");
        System.out.println("2 - Remover movimentacao (por descricao)");
        System.out.print("Escolha: ");
        int op = Integer.parseInt(sc.nextLine());

        if (op == 1) {
            if (contaContabil.isEmpty()) {
                System.out.println("Nao tem contas cadastradas.");
                return;
            }

            System.out.print("Codigo para remover: ");
            String codigo = sc.nextLine();

            for (int i = 0; i < contaContabil.size(); i++) {
                if (contaContabil.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                    contaContabil.remove(i);
                    System.out.println("Conta removida!");
                    return;
                }
            }
            System.out.println("Conta nao encontrada.");

        } else if (op == 2) {
            if (movimentacaoExtrato.isEmpty()) {
                System.out.println("Nao tem movimentacoes cadastradas.");
                return;
            }

            System.out.print("Descricao para remover: ");
            String desc = sc.nextLine();

            for (int i = 0; i < movimentacaoExtrato.size(); i++) {
                if (movimentacaoExtrato.get(i).getDescricao().equalsIgnoreCase(desc)) {
                    movimentacaoExtrato.remove(i);
                    System.out.println("Movimentacao removida!");
                    return;
                }
            }
            System.out.println("Movimentacao nao encontrada.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    public void listar() {
        System.out.println("\n--- LISTA DE CONTAS ---");
        if (contaContabil.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (contas c : contaContabil) {
                System.out.println(c);
            }
        }

        System.out.println("\n--- LISTA DE MOVIMENTACOES ---");
        if (movimentacaoExtrato.isEmpty()) {
            System.out.println("Nenhuma movimentacao cadastrada.");
        } else {
            for (fluxo f : movimentacaoExtrato) {
                System.out.println(f);
            }
        }
    }
}
