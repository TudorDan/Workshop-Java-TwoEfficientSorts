package simpleSorts;

public class InsertionSort {
    public static void process(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int consideredSorted = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > consideredSorted) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = consideredSorted;
        }
    }
}
