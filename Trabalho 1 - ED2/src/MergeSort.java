public class MergeSort {
    private static int comparisonCount = 0;
    private static int swapCount = 0;

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comparisonCount++;
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
                swapCount++;
            } else {
                arr[k++] = R[j++];
                swapCount++;
            }
        }

        while (i < n1) {
            arr[k++] = L[i++];
            swapCount++;
        }

        while (j < n2) {
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
