package Contabilidadecomplex;

import java.util.LinkedList;
import java.util.Scanner;

public class sistem {

    private LinkedList<contas> contaContabil = new LinkedList<>();
    private LinkedList<fluxo> movimentacaoExtrato = new LinkedList<>();

    // ======================
    // Ações do menu principal
    // ======================
    public void cadastrar(Scanner sc) {
        System.out.println("\n--- CADASTRAR ---");
        System.out.println("1 - Conta contabil");
        System.out.println("2 - Movimentacao bancaria");
        System.out.println("0 - Voltar");

        int op = lerInt(sc, "Escolha: ", 0, 2);
        if (op == 0) return;

        if (op == 1) cadastrarConta(sc);
        if (op == 2) cadastrarMov(sc);
    }

    public void remover(Scanner sc) {
        System.out.println("\n--- REMOVER ---");
        System.out.println("1 - Remover conta (por codigo)");
        System.out.println("2 - Remover movimentacao (por descricao)");
        System.out.println("0 - Voltar");

        int op = lerInt(sc, "Escolha: ", 0, 2);
        if (op == 0) return;

        if (op == 1) removerConta(sc);
        if (op == 2) removerMov(sc);
    }

    public void listar() {
        System.out.println("\n--- CONTAS ---");
        if (contaContabil.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (contas c : contaContabil) System.out.println(c.linha());
        }

        System.out.println("\n--- MOVIMENTACOES ---");
        if (movimentacaoExtrato.isEmpty()) {
            System.out.println("Nenhuma movimentacao cadastrada.");
        } else {
            for (fluxo f : movimentacaoExtrato) System.out.println(f.linha());
        }
    }

    // ======================
    // Cadastro (com record)
    // ======================
    private void cadastrarConta(Scanner sc) {
        String codigo = lerTexto(sc, "Codigo: ");
        if (buscarConta(codigo) != null) {
            System.out.println("Ja existe conta com esse codigo.");
            return;
        }

        String desc = lerTexto(sc, "Descricao: ");
        Grupo grupo = escolherEnum(sc, "Grupo", Grupo.values());
        TipoConta tipo = escolherEnum(sc, "Tipo da conta", TipoConta.values());

        cadastroConta dto = new cadastroConta(codigo, desc, grupo, tipo);
        contaContabil.add(new contas(dto.codigo(), dto.descricao(), dto.grupo(), dto.tipo()));
        System.out.println("Conta cadastrada!");
    }

    private void cadastrarMov(Scanner sc) {
        String desc = lerTexto(sc, "Descricao: ");
        Grupo grupo = escolherEnum(sc, "Grupo", Grupo.values());
        Natureza natureza = escolherEnum(sc, "Natureza", Natureza.values());
        double valor = lerDouble(sc, "Valor (ex: 1500.50 ou 1.500,50): ");

        cadastroFluxo dto = new cadastroFluxo(desc, grupo, valor, natureza);
        movimentacaoExtrato.add(new fluxo(dto.descricao(), dto.grupo(), dto.valor(), dto.natureza()));
        System.out.println("Movimentacao cadastrada!");
    }

    // ======================
    // Remoção
    // ======================
    private void removerConta(Scanner sc) {
        if (contaContabil.isEmpty()) {
            System.out.println("Nao tem contas cadastradas.");
            return;
        }

        String codigo = lerTexto(sc, "Codigo para remover: ");

        for (int i = 0; i < contaContabil.size(); i++) {
            if (contaContabil.get(i).id().equalsIgnoreCase(codigo)) {
                contaContabil.remove(i);
                System.out.println("Conta removida!");
                return;
            }
        }
        System.out.println("Conta nao encontrada.");
    }

    private void removerMov(Scanner sc) {
        if (movimentacaoExtrato.isEmpty()) {
            System.out.println("Nao tem movimentacoes cadastradas.");
            return;
        }

        String desc = lerTexto(sc, "Descricao para remover: ");

        for (int i = 0; i < movimentacaoExtrato.size(); i++) {
            if (movimentacaoExtrato.get(i).id().equalsIgnoreCase(desc)) {
                movimentacaoExtrato.remove(i);
                System.out.println("Movimentacao removida!");
                return;
            }
        }
        System.out.println("Movimentacao nao encontrada.");
    }

    // ======================
    // Helpers (simples)
    // ======================
    private contas buscarConta(String codigo) {
        for (contas c : contaContabil) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }

    private String lerTexto(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String t = sc.nextLine().trim();
            if (!t.isEmpty()) return t;
            System.out.println("Nao pode ser vazio.");
        }
    }

    private int lerInt(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(s);
                if (v < min || v > max) {
                    System.out.println("Digite entre " + min + " e " + max + ".");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }

    private double lerDouble(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("Nao pode ser vazio.");
                continue;
            }
            // aceita 1.500,50 e 1500.50
            String normal = s.replace(".", "").replace(",", ".");
            try {
                return Double.parseDouble(normal);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido.");
            }
        }
    }

    private <T extends Enum<T>> T escolherEnum(Scanner sc, String titulo, T[] valores) {
        System.out.println("\nEscolha " + titulo + ":");
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + " - " + valores[i].name());
        }
        int op = lerInt(sc, "Opcao: ", 1, valores.length);
        return valores[op - 1];
    }
}
