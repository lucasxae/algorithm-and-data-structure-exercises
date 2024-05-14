package OrdenaçãoRecursiva;

import java.util.Arrays;

public class bubble {
    
    // Função auxiliar para realizar uma iteração do bubble sort recursivo
    static void bubbleSortIteration(int[] arr, int n) {
        if (n == 1)
            return;
        
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        
        // Chama recursivamente a função para o próximo elemento
        bubbleSortIteration(arr, n - 1);
    }
    
    // Função principal do bubble sort recursivo
    static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 0)
            return;
        
        // Realiza uma iteração do bubble sort recursivo
        bubbleSortIteration(arr, n);
        
        // Chama recursivamente a função para os próximos elementos
        bubbleSortRecursive(arr, n - 1);
    }
    
    // Função de impressão para verificar se o vetor foi ordenado corretamente
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.print("Vetor original: ");
        printArray(arr);
        
        bubbleSortRecursive(arr, arr.length);
        
        System.out.print("Vetor ordenado: ");
        printArray(arr);
    }
}
