import java.util.Arrays;

public class Timsort {
    private static int comparisonCount = 0; // Contador de comparações
    private static int swapCount = 0;       // Contador de trocas

    static final int RUN = 32;

    public static void sort(int[] arr) {
        int n = arr.length;

        // Ordenar subarrays de tamanho RUN usando Insertion Sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }

        // Fundir subarrays em tamanhos crescentes
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left) {
                comparisonCount++; // Contar comparação
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    swapCount++; // Contar movimento como troca
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] L = new int[len1];
        int[] R = new int[len2];

        for (int i = 0; i < len1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < len2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            comparisonCount++; // Contar comparação
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
                swapCount++; // Considerar movimento como troca
            } else {
                arr[k++] = R[j++];
                swapCount++; // Considerar movimento como troca
            }
        }

        while (i < len1) {
            arr[k++] = L[i++];
            swapCount++;
        }

        while (j < len2) {
            arr[k++] = R[j++];
            swapCount++;
        }
    }

    public static void resetCounters() {
        comparisonCount = 0;
        swapCount = 0;
    }

    public static int getComparisonCount() {
        return comparisonCount;
    }

    public static int getSwapCount() {
        return swapCount;
    }
}
