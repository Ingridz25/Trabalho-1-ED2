
import java.util.ArrayList;
import java.util.List;

public class StableQuickSort{

    private static int comparisonCount = 0;
    private static int swapCount = 0;

    public static class Element {
        int value;
        int originalIndex;

        public Element(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }

        @Override
        public String toString() {
            return value + "(" + originalIndex + ")";
        }
    }

    public static void sort(List<Element> arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = chooseMedian(arr, left, right);
        Element pivotValue = arr.get(pivotIndex);

        List<Element> less = new ArrayList<>();
        List<Element> equal = new ArrayList<>();
        List<Element> greater = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            comparisonCount++;
            Element current = arr.get(i);
            if (current.value < pivotValue.value) {
                less.add(current);
                swapCount++;
            } else if (current.value == pivotValue.value) {
                equal.add(current);
                swapCount++;
            } else {
                greater.add(current);
                swapCount++;
            }
        }

        System.out.println("Após partiçao (pivô = " + pivotValue.value + "): ");
        printArray(less, equal, greater);

        sort(less, 0, less.size() - 1);
        sort(greater, 0, greater.size() - 1);

        int index = left;
        for (Element e : less) arr.set(index++, e);
        for (Element e : equal) arr.set(index++, e);
        for (Element e : greater) arr.set(index++, e);
    }

    private static int chooseMedian(List<Element> arr, int left, int right) {
        int mid = (left + right) / 2;
        Element a = arr.get(left);
        Element b = arr.get(mid);
        Element c = arr.get(right);

        if ((a.value >= b.value && a.value <= c.value) || (a.value <= b.value && a.value >= c.value)) {
            return left;
        } else if ((b.value >= a.value && b.value <= c.value) || (b.value <= a.value && b.value >= c.value)) {
            return mid;
        } else {
            return right;
        }
    }

    public static List<Element> generateElementList(int[] array) {
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new Element(array[i], i));
        }
        return list;
    }

    private static void printArray(List<Element> less, List<Element> equal, List<Element> greater) {
        System.out.print("Menores: ");
        for (Element e : less) {
            System.out.print(e + " ");
        }
        System.out.print(" | Iguais: ");
        for (Element e : equal) {
            System.out.print(e + " ");
        }
        System.out.print(" | Maiores: ");
        for (Element e : greater) {
            System.out.print(e + " ");
        }
        System.out.println();
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





















/*import java.util.ArrayList;
import java.util.List;

public class StableQuickSort {
    private static int comparisonCount = 0;
    private static int swapCount = 0;

    public static class Element {
        int value;
        int originalIndex;

        public Element(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }
    }

    public static void sort(List<Element> arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = chooseMedian(arr, left, right);
        Element pivotValue = arr.get(pivotIndex);

        List<Element> less = new ArrayList<>();
        List<Element> equal = new ArrayList<>();
        List<Element> greater = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            comparisonCount++;
            Element current = arr.get(i);
            if (current.value < pivotValue.value) {
                less.add(current);
                swapCount++;
            } else if (current.value == pivotValue.value) {
                equal.add(current);
                swapCount++;
            } else {
                greater.add(current);
                swapCount++;
            }
        }

        sort(less, 0, less.size() - 1);
        sort(greater, 0, greater.size() - 1);

        int index = left;
        for (Element e : less) arr.set(index++, e);
        for (Element e : equal) arr.set(index++, e);
        for (Element e : greater) arr.set(index++, e);
    }

    private static int chooseMedian(List<Element> arr, int left, int right) {
        int mid = (left + right) / 2;
        Element a = arr.get(left);
        Element b = arr.get(mid);
        Element c = arr.get(right);

        if ((a.value >= b.value && a.value <= c.value) || (a.value <= b.value && a.value >= c.value)) {
            return left;
        } else if ((b.value >= a.value && b.value <= c.value) || (b.value <= a.value && b.value >= c.value)) {
            return mid;
        } else {
            return right;
        }
    }

    public static List<Element> generateElementList(int[] array) {
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(new Element(array[i], i));
        }
        return list;
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
*/