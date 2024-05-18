package OrdenaçãoRecursiva;

public class extrapoint {

    class selecaoRecursivo {

        private static int buscarMenorIndice(int[] vetor, int inicio, int menorIndice) {
            if (inicio == vetor.length) {
                return menorIndice;
            }
            if (vetor[inicio] < vetor[menorIndice]) {
                menorIndice = inicio;
            }
            return buscarMenorIndice(vetor, inicio + 1, menorIndice);
        }

        public static void selectionSortRecursivo(int[] vetor, int inicio) {
            if (inicio >= vetor.length - 1) {
                return;
            }

            int menorIndice = buscarMenorIndice(vetor, inicio, inicio);

            if (menorIndice != inicio) {
                int temp = vetor[inicio];
                vetor[inicio] = vetor[menorIndice];
                vetor[menorIndice] = temp;
            }
            selectionSortRecursivo(vetor, inicio + 1);
        }
    }

    class bolhaRecursivo {

        public static boolean bubbleSortRecursivo(int[] vetor, int n, int i, boolean troca) {

            if (i == n - 1) {

                if (!troca || n == 1) {
                    return false;
                }
                return bubbleSortRecursivo(vetor, n - 1, 0, false);
            }

            if (vetor[i] > vetor[i + 1]) {
                int temp = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = temp;
                troca = true;
            }

            return bubbleSortRecursivo(vetor, n, i + 1, troca);
        }
    }
}
