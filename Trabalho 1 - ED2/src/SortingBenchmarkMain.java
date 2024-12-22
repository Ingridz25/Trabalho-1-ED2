import java.util.ArrayList;
import java.util.List;

public class SortingBenchmarkMain {

    public static void main(String[] args) {
        // Array de teste comum para todos os algoritmos
        int[] inputArray = {12, 45, 87, 2, 9, 2365, 0};

        // StableQuickSort - mostra o passo a passo
        System.out.println("\n=== Stable QuickSort ===");
        List<StableQuickSort.Element> stableQuickSortArr = StableQuickSort.generateElementList(inputArray);
        StableQuickSort.resetCounters();
        long stableQuickSortStartTime = System.nanoTime();
        StableQuickSort.sort(stableQuickSortArr, 0, stableQuickSortArr.size() - 1);
        long stableQuickSortEndTime = System.nanoTime();
        System.out.println("Array antes da ordenação (Stable QuickSort):");
        printArray(StableQuickSort.generateElementList(inputArray));
        System.out.println("Array após a ordenação (Stable QuickSort):");
        printArray(stableQuickSortArr);
        System.out.println("Tempo de execução (ns): " + (stableQuickSortEndTime - stableQuickSortStartTime));
        System.out.println("Comparações: " + StableQuickSort.getComparisonCount());
        System.out.println("Trocas: " + StableQuickSort.getSwapCount());

        // BubbleSort
        System.out.println("\n=== Bubble Sort ===");
        int[] bubbleSortArr = inputArray.clone();
        BubbleSort.resetCounters();
        System.out.println("Array antes da ordenação: " + arrayToString(bubbleSortArr));
        long bubbleSortStartTime = System.nanoTime();
        BubbleSort.sort(bubbleSortArr);
        long bubbleSortEndTime = System.nanoTime();
        System.out.println("Array após a ordenação: " + arrayToString(bubbleSortArr));
        System.out.println("Tempo de execução (ns): " + (bubbleSortEndTime - bubbleSortStartTime));
        System.out.println("Comparações: " + BubbleSort.getComparisonCount());
        System.out.println("Trocas: " + BubbleSort.getSwapCount());

        // InsertionSort
        System.out.println("\n=== Insertion Sort ===");
        int[] insertionSortArr = inputArray.clone();
        InsertionSort.resetCounters();
        System.out.println("Array antes da ordenação: " + arrayToString(insertionSortArr));
        long insertionSortStartTime = System.nanoTime();
        InsertionSort.sort(insertionSortArr);
        long insertionSortEndTime = System.nanoTime();
        System.out.println("Array após a ordenação: " + arrayToString(insertionSortArr));
        System.out.println("Tempo de execução (ns): " + (insertionSortEndTime - insertionSortStartTime));
        System.out.println("Comparações: " + InsertionSort.getComparisonCount());
        System.out.println("Trocas: " + InsertionSort.getSwapCount());

        // MergeSort
        System.out.println("\n=== Merge Sort ===");
        int[] mergeSortArr = inputArray.clone();
        MergeSort.resetCounters();
        System.out.println("Array antes da ordenação: " + arrayToString(mergeSortArr));
        long mergeSortStartTime = System.nanoTime();
        MergeSort.sort(mergeSortArr, 0, mergeSortArr.length - 1);
        long mergeSortEndTime = System.nanoTime();
        System.out.println("Array após a ordenação: " + arrayToString(mergeSortArr));
        System.out.println("Tempo de execução (ns): " + (mergeSortEndTime - mergeSortStartTime));
        System.out.println("Comparações: " + MergeSort.getComparisonCount());
        System.out.println("Trocas: " + MergeSort.getSwapCount());

        // StandardQuickSort
        System.out.println("\n=== Standard QuickSort ===");
        int[] standardQuickSortArr = inputArray.clone();
        StandardQuickSort.resetCounters();
        System.out.println("Array antes da ordenação: " + arrayToString(standardQuickSortArr));
        long standardQuickSortStartTime = System.nanoTime();
        StandardQuickSort.sort(standardQuickSortArr, 0, standardQuickSortArr.length - 1);
        long standardQuickSortEndTime = System.nanoTime();
        System.out.println("Array após a ordenação: " + arrayToString(standardQuickSortArr));
        System.out.println("Tempo de execução (ns): " + (standardQuickSortEndTime - standardQuickSortStartTime));
        System.out.println("Comparações: " + StandardQuickSort.getComparisonCount());
        System.out.println("Trocas: " + StandardQuickSort.getSwapCount());

        // TimSort
        System.out.println("\n=== TimSort ===");
        int[] timSortArr = inputArray.clone();
        Timsort.resetCounters();
        System.out.println("Array antes da ordenação: " + arrayToString(timSortArr));
        long timSortStartTime = System.nanoTime();
        Timsort.sort(timSortArr);
        long timSortEndTime = System.nanoTime();
        System.out.println("Array após a ordenação: " + arrayToString(timSortArr));
        System.out.println("Tempo de execução (ns): " + (timSortEndTime - timSortStartTime));
        System.out.println("Comparações: " + Timsort.getComparisonCount());
        System.out.println("Trocas: " + Timsort.getSwapCount());
    }

    private static void printArray(List<StableQuickSort.Element> arr) {
        for (StableQuickSort.Element e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
