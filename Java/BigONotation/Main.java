packeage BigONatation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final int QUANTIDADE = 1_000_000;
    private static final int INDICE_MEIO = QUANTIDADE / 2;
    private static final int ITEM_NOVO = -1;
    private static final int VALOR_INEXISTENTE = -2;

    // --- Códigos de Cor ANSI ---
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    // --- Limites para as cores (em milissegundos) ---
    private static final double GREEN_THRESHOLD = 0.10;
    private static final double YELLOW_THRESHOLD = 1.0;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        testarImplementacao(arrayList, "ArrayList");
        testarImplementacao(linkedList, "LinkedList");
    }

    public static void preencherLista(List<Integer> list, int quantidade) {
        // Otimização específica para ArrayList:
        // Aloca previamente a memória necessária de uma só vez,
        // evitando múltiplas expansões do array interno.
        if (list instanceof ArrayList) {
            ((ArrayList<Integer>) list).ensureCapacity(quantidade);
        }

        for (int i = 0; i < quantidade; i++) {
            list.add(i);
        }
    }

    /**
     * Mede e registra o tempo de uma operação com cores.
     * @param operacao O nome da operação para exibir.
     * @param startTime O tempo (em nanos) em que a operação começou.
     */
    public static void registrarTempo(String operacao, long startTime) {
        long endTime = System.nanoTime();
        long durationNanos = endTime - startTime;
        double durationMs = durationNanos / 1_000_000.0;

        // Pega a cor apropriada com base no tempo
        String color = getColor(durationMs);

        // Imprime o texto formatado com a cor e reseta no final
        System.out.printf("  %-25s: %s%.4f ms%s%n",
                operacao,
                color,       // Aplica a cor
                durationMs,
                ANSI_RESET // Reseta para a cor padrão
        );
    }

    /**
     * Retorna o código de cor ANSI com base no tempo de duração.
     */
    private static String getColor(double durationMs) {
        if (durationMs < GREEN_THRESHOLD) {
            return ANSI_GREEN;
        } else if (durationMs < YELLOW_THRESHOLD) {
            return ANSI_YELLOW;
        } else {
            return ANSI_RED;
        }
    }

    public static void testarImplementacao(List<Integer> list, String nomeDaLista) {
        System.out.println("\n----- Testando: " + nomeDaLista + " -----");

        long inicio = System.nanoTime();
        preencherLista(list, QUANTIDADE);
        registrarTempo("Inicialização (" + QUANTIDADE + " itens)", inicio);

        inicio = System.nanoTime();
        list.get(0);
        registrarTempo("Get (Inicio)", inicio);

        inicio = System.nanoTime();
        list.get(INDICE_MEIO);
        registrarTempo("Get (Meio)", inicio);

        inicio = System.nanoTime();
        list.get(list.size() - 1);
        registrarTempo("Get (Fim)", inicio);

        inicio = System.nanoTime();
        list.add(0, ITEM_NOVO);
        registrarTempo("Add (Início)", inicio);

        inicio = System.nanoTime();
        list.add(INDICE_MEIO, ITEM_NOVO);
        registrarTempo("Add (Meio)", inicio);

        inicio = System.nanoTime();
        list.add(ITEM_NOVO);
        registrarTempo("Add (Fim)", inicio);

        inicio = System.nanoTime();
        list.remove(0);
        registrarTempo("Remove (Início)", inicio);

        inicio = System.nanoTime();
        list.remove(INDICE_MEIO);
        registrarTempo("Remove (Meio)", inicio);

        inicio = System.nanoTime();
        list.remove(list.size() - 1);
        registrarTempo("Remove (Fim)", inicio);

        inicio = System.nanoTime();
        list.contains(VALOR_INEXISTENTE);
        registrarTempo("Search (Contains)", inicio);
    }
}