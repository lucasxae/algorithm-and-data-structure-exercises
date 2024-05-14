package OrdenaçãoRecursiva;

import java.util.Arrays;

public class select {

    // Função auxiliar para encontrar o índice do menor elemento em um vetor
    static int findMinIndex(int[] arr, int start, int end) {
        if (start == end)
            return start;

        int minIndex = findMinIndex(arr, start + 1, end);
        return (arr[start] < arr[minIndex]) ? start : minIndex;
    }

    // Função auxiliar para trocar dois elementos de um vetor
    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Função principal do selection sort recursivo
    static void selectionSortRecursive(int[] arr, int start) {
        if (start == arr.length - 1)
            return;

        int minIndex = findMinIndex(arr, start, arr.length - 1);
        if (minIndex != start)
            swap(arr, minIndex, start);

        selectionSortRecursive(arr, start + 1);
    }

    // Função de impressão para verificar se o vetor foi ordenado corretamente
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };
        System.out.print("Vetor original: ");
        printArray(arr);

        selectionSortRecursive(arr, 0);

        System.out.print("Vetor ordenado: ");
        printArray(arr);
    }
}
