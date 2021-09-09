package complexSorts;

public class MergeSort {
    /**
     * Merge sort that sorts in place the given array
     * @param arr the given array
     * @param first the index of the first element
     * @param last the index of the last element
     */
    public static void process(int[] arr, int first, int last) {
        if (last - first >= 1) {
            int middle = (first + last) / 2;
            process(arr, first, middle);
            process(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    /**
     * In place merge of a given array from 2 sub arrays:
     * 1) the given array's first half;
     * 2) the given array's second half.
     * @param arr the given array
     * @param left given array start element index
     * @param middle given array middle element index
     * @param right given array end element index
     */
    private static void merge(int[] arr, int left, int middle, int right) {
        int[] resultArr = new int[right - left + 1];
        int firstSubArrIndex = left; //first subarray start element index
        int secondSubArrIndex = middle + 1; //second subarray start element index
        int i = 0;
        while (firstSubArrIndex <= middle && secondSubArrIndex <= right) {
            if (arr[firstSubArrIndex] < arr[secondSubArrIndex]) {
                resultArr[i] = arr[firstSubArrIndex];
                firstSubArrIndex++;
            } else {
                resultArr[i] = arr[secondSubArrIndex];
                secondSubArrIndex++;
            }
            i++;
        }
        while (firstSubArrIndex <= middle){
            resultArr[i] = arr[firstSubArrIndex];
            firstSubArrIndex++;
            i++;
        }
        while (secondSubArrIndex <= right) {
            resultArr[i] = arr[secondSubArrIndex];
            secondSubArrIndex++;
            i++;
        }
        for (int j = 0, k = left; k <= right; j++, k++) {
            arr[k] = resultArr[j];
        }
    }
}
