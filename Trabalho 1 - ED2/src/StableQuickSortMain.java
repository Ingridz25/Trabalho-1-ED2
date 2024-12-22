import java.util.ArrayList;
import java.util.List;

public class StableQuickSortMain {
public static void main(String[] args) {
    // Array de entrada simples
    int[] inputArray = {1, 3, 2, 1, 3};

    // Converter o array de inteiros para uma lista de StableQuickSort.Element
    List<StableQuickSort.Element> arr = generateElementList(inputArray);

    // Exibir o array antes da ordenação
    System.out.println("Antes da ordenação:");
    printArray(arr);

    // Executar o Stable QuickSort
    long startTime = System.nanoTime();
    StableQuickSort.resetCounters(); // Reseta os contadores
    StableQuickSort.sort(arr, 0, arr.size() - 1);
    long endTime = System.nanoTime();

    // Exibir o array após a ordenação
    System.out.println("Depois da ordenação:");
    printArray(arr);

    // Exibir métricas de desempenho
    System.out.println("Tempo de execução (ns): " + (endTime - startTime));
    System.out.println("Comparações: " + StableQuickSort.getComparisonCount());
    System.out.println("Trocas: " + StableQuickSort.getSwapCount());
}

// Mtodo para converter um array de inteiros em uma lista de StableQuickSort.Element
private static List<StableQuickSort.Element> generateElementList(int[] inputArray) {
    List<StableQuickSort.Element> elements = new ArrayList<>();
    for (int i = 0; i < inputArray.length; i++) {
        elements.add(new StableQuickSort.Element(inputArray[i], i));
    }
    return elements;
}

// Mtodo para exibir o array de elementos
private static void printArray(List<StableQuickSort.Element> arr) {
    for (StableQuickSort.Element element : arr) {
        System.out.print(element.value + "(" + element.originalIndex + ") ");
    }
    System.out.println();
    }
}














/*
import java.util.ArrayList;
import java.util.List;

public class StableQuickSortMain {

    public static void main(String[] args) {
        // Array pequeno para exemplo
        StableQuickSort.Element[] elements = {
                new StableQuickSort.Element(1, 0),
                new StableQuickSort.Element(2, 1),
                new StableQuickSort.Element(4, 2)
        };

        // Converter o array para uma lista
        List<StableQuickSort.Element> arr = new ArrayList<>(List.of(elements));

        // Exibir o array antes da ordenação
        System.out.println("Antes da ordenação:");
        printArray(arr);

        // Executar o Stable QuickSort
        long startTime = System.nanoTime();
        StableQuickSort.resetCounters(); // Reseta os contadores
        StableQuickSort.sort(arr, 0, arr.size() - 1);
        long endTime = System.nanoTime();

        // Exibir o array após a ordenação
        System.out.println("Depois da ordenação:");
        printArray(arr);

        // Exibir métricas de desempenho
        System.out.println("Tempo de execução (ns): " + (endTime - startTime));
        System.out.println("Comparações: " + StableQuickSort.getComparisonCount());
        System.out.println("Trocas: " + StableQuickSort.getSwapCount());
    }

    //Metodo para exibir o array de elementos
    private static void printArray(List<StableQuickSort.Element> arr) {
        for (StableQuickSort.Element element : arr) {
            System.out.print(element.value + "(" + element.originalIndex + ") ");
        }
        System.out.println();
    }
}
*/