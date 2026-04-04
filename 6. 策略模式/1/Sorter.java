abstract class SortStrategy {
    public final void processSortStrategy(int[] data) {
        sorttype();
        sort(data);
        System.out.println();
    }

    abstract void sorttype();

    abstract void sort(int[] data);
}

class Swap {
    public Swap() {
    }

    public static void swap(int[] data, int x, int y) {
        int t = data[x];
        data[x] = data[y];
        data[y] = t;
    }
}

class OutputArray {
    public OutputArray() {
    }
    public static void output(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}

class BubbleSort extends SortStrategy {
    @Override
    public void sorttype() {
        System.out.println("Using Bubble Sort");
    }
    @Override
    public void sort(int[] data) {
        bubbleSort(data, data.length);
        OutputArray.output(data);
    }

    private void bubbleSort(int[] data, int length) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length - i; j++) {
                if (data[j - 1] > data[j])
                    Swap.swap(data, j - 1, j);
            }
        }
    }
}

class MergeSort extends SortStrategy {
    @Override
    public void sorttype() {
        System.out.println("Using Merge Sort");
    }
    @Override
    void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
        OutputArray.output(data);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int[] L = java.util.Arrays.copyOfRange(arr, left, middle + 1);
        int[] R = java.util.Arrays.copyOfRange(arr, middle + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length)
            arr[k++] = L[i++];
        while (j < R.length)
            arr[k++] = R[j++];
    }
}

class QuickSort extends SortStrategy {
    @Override
    public void sorttype() {
        System.out.println("Using Quick Sort");
    }
    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
        OutputArray.output(data);
    }
    private void quickSort(int[] data, int low, int high) {
        if (low >= high)
            return;

        int left = low, right = high, pivot = data[low], i = low + 1;

        while (i <= right) {
            if (pivot > data[i])
                Swap.swap(data, i++, left++);
            else if (pivot < data[i])
                Swap.swap(data, i, right--);
            else i++;
        }
        quickSort(data, low, left - 1);
        quickSort(data, right + 1, high);
    }

}

public class Sorter {
    private SortStrategy sortStrategy;

    public Sorter() {
    }
    public void setSortStrategy(SortStrategy sortStrategy) { this.sortStrategy = sortStrategy; }
    public void sort(int[] data) {
        sortStrategy.processSortStrategy(data);
    }
    public static void main(String[] args) {
        int[] data = { 2, 3, 1 };
        Sorter p = new Sorter();
        p.setSortStrategy(new BubbleSort());
        p.sort(data);
        p = new Sorter();
        p.setSortStrategy(new MergeSort());
        p.sort(data); // 顯示 "Using Merge Sort"
        p = new Sorter();
        p.setSortStrategy(new QuickSort());
        p.sort(data); // 顯示 "Using Quick Sort"
    }
}
