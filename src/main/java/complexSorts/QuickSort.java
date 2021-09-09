package complexSorts;

public class QuickSort {
    public static void process(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            process(arr, start, pivotIndex - 1);
            process(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int indexForSwap = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                indexForSwap++;
                int temp = arr[i];
                arr[i] = arr[indexForSwap];
                arr[indexForSwap] = temp;
            }
        }
        indexForSwap++;
        int temp = arr[end];
        arr[end] = arr[indexForSwap];
        arr[indexForSwap] = temp;
        return indexForSwap;
    }
}
