public class StandardQuickSort {
    private static int comparisonCount = 0;
    private static int swapCount = 0;

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);
        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            comparisonCount++;
            if (arr[j] <= pivot) {
                swapCount++;
                int temp = arr[i + 1];
                arr[++i] = arr[j];
                arr[j] = temp;
            }
        }

        swapCount++;
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
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
