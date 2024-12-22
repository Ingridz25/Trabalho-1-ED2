public class InsertionSort {
    private static int comparisonCount = 0;
    private static int swapCount = 0;

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comparisonCount++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    swapCount++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
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
