packeage BigONatation;

/**
 * Esta classe demonstra exemplos simples de diferentes complexidades
 * de tempo (Big O) em métodos Java.
 */
public class BigOExamples {

    public static void main(String[] args) {
        // --- Configuração ---
        // Usamos arrays pequenos para O(n^2), O(n^3), O(2^n) e O(n!)
        // para que eles não demorem uma eternidade para executar.
        int[] arrayPequeno = {1, 2, 3};
        int[] arrayMedio = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int nPequeno = 4; // Para O(2^n)
        String stringPequena = "abc"; // Para O(n!)

        System.out.println("Executando exemplos de Big O...\n");

        // --- O(1) ---
        System.out.println("--- 1. O(1) - Tempo Constante ---");
        constantTime(arrayMedio);
        System.out.println("---------------------------------\n");

        // --- O(n) ---
        System.out.println("--- 2. O(n) - Tempo Linear ---");
        linearTime(arrayMedio);
        System.out.println("------------------------------\n");

        // --- O(n^2) ---
        System.out.println("--- 3. O(n^2) - Tempo Quadrático ---");
        quadraticTime(arrayPequeno);
        System.out.println("------------------------------------\n");

        // --- O(n^3) ---
        System.out.println("--- 4. O(n^3) - Tempo Cúbico ---");
        cubicTime(arrayPequeno);
        System.out.println("----------------------------------\n");

        // --- O(log n) ---
        System.out.println("--- 5. O(log n) - Tempo Logarítmico ---");
        logarithmicTime(arrayMedio, 7); // Busca o número 7
        logarithmicTime(arrayMedio, 11); // Busca o número 11 (não existe)
        System.out.println("---------------------------------------\n");

        // --- O(n log n) ---
        System.out.println("--- 6. O(n log n) - Tempo Log-Linear ---");
        logLinearTime(arrayMedio);
        System.out.println("----------------------------------------\n");

        // --- O(2^n) ---
        System.out.println("--- 7. O(2^n) - Tempo Exponencial ---");
        System.out.println("Calculando Fibonacci(" + nPequeno + ")...");
        int fibResult = fibonacciRecursive(nPequeno);
        System.out.println("Resultado: " + fibResult);
        System.out.println("-------------------------------------\n");

        // --- O(n!) ---
        System.out.println("--- 8. O(n!) - Tempo Fatorial ---");
        System.out.println("Encontrando permutações de '" + stringPequena + "':");
        factorialTime("", stringPequena);
        System.out.println("---------------------------------\n");
    }

    // ##################################################
    // MÉTODOS DE EXEMPLO
    // ##################################################

    /**
     * O(1) - Tempo Constante
     * Não importa o tamanho do array (n), esta operação
     * sempre leva o mesmo tempo. Estamos apenas acessando um
     * único elemento pelo seu índice.
     */
    public static void constantTime(int[] array) {
        System.out.println("O primeiro elemento é: " + array[0]);
    }

    /**
     * O(n) - Tempo Linear
     * O tempo de execução cresce linearmente com o tamanho
     * da entrada 'n' (o comprimento do array). Se o array
     * dobrar de tamanho, este metodo levará o dobro do tempo.
     */
    public static void linearTime(int[] array) {
        System.out.println("Imprimindo todos os elementos:");
        for (int item : array) {
            System.out.println(item);
        }
    }

    /**
     * O(n^2) - Tempo Quadrático
     * O tempo de execução cresce quadraticamente. Isso é
     * comum em loops aninhados. Para cada 'n' elementos do
     * loop externo, o loop interno executa 'n' vezes.
     * Total de operações = n * n = n^2.
     */
    public static void quadraticTime(int[] array) {
        System.out.println("Imprimindo todos os pares:");
        for (int i : array) { // Loop 1 (n)
            for (int j : array) { // Loop 2 (n)
                System.out.println(i + ", " + j);
            }
        }
    }

    /**
     * O(n^3) - Tempo Cúbico
     * Semelhante ao quadrático, mas com três loops aninhados.
     * O tempo de execução é n * n * n = n^3.
     * (Isso começa a ficar muito lento rapidamente!)
     */
    public static void cubicTime(int[] array) {
        System.out.println("Imprimindo todos os trios:");
        for (int i : array) { // Loop 1 (n)
            for (int j : array) { // Loop 2 (n)
                for (int k : array) { // Loop 3 (n)
                    System.out.println(i + ", " + j + ", " + k);
                }
            }
        }
    }

    /**
     * O(log n) - Tempo Logarítmico
     * O tempo de execução cresce logaritmicamente. A cada passo,
     * o algoritmo descarta metade dos dados restantes. A Busca
     * Binária é o exemplo clássico.
     * (Requer que o array esteja ORDENADO).
     */
    public static void logarithmicTime(int[] sortedArray, int target) {
        System.out.println("Buscando por " + target + "...");
        int low = 0;
        int high = sortedArray.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = sortedArray[mid];
            if (midValue == target) {
                System.out.println("Elemento " + target + " encontrado no índice " + mid);
                found = true;
                break;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Elemento " + target + " não encontrado.");
        }
    }

    /**
     * O(n log n) - Tempo Log-Linear
     * Esta é uma complexidade muito comum em algoritmos de
     * ordenação eficientes (como Merge Sort ou Quick Sort).
     * Um exemplo simples é rodar um loop O(n) e, DENTRO dele,
     * executar uma operação O(log n).
     */
    public static void logLinearTime(int[] sortedArray) {
        System.out.println("Executando 'n' operações 'log n'...");
        // Exemplo: Para cada elemento (O(n))...
        for (int i = 0; i < sortedArray.length; i++) {
            // ...faça uma busca binária (O(log n)) por ele.
            // (Isso é um exemplo artificial, mas demonstra a complexidade).
            // Vamos apenas simular a busca para não poluir o console.
            findElement(sortedArray, sortedArray[i]);
        }
        System.out.println("Operação O(n log n) concluída.");
        // NOTA: Chamar Arrays.sort(array) também seria um exemplo O(n log n).
    }

    // Metodo auxiliar silencioso para O(n log n)
    private static boolean findElement(int[] sortedArray, int target) {
        int low = 0;
        int high = sortedArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midValue = sortedArray[mid];
            if (midValue == target) return true;
            else if (midValue < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }


    /**
     * O(2^n) - Tempo Exponencial
     * O tempo de execução dobra a cada novo elemento adicionado.
     * O exemplo clássico é o cálculo recursivo de Fibonacci
     * (sem otimização/memoização).
     */
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        // Cada chamada gera DUAS novas chamadas
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /**
     * O(n!) - Tempo Fatorial
     * O tempo de execução cresce fatorialmente (n * (n-1) * ...).
     * Este é o pior tipo de complexidade. O exemplo clássico
     * é encontrar todas as permutações de um conjunto.
     */
    public static void factorialTime(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            // Para cada caractere (n), faz uma chamada recursiva
            // com uma string de tamanho (n-1)
            for (int i = 0; i < n; i++) {
                factorialTime(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}