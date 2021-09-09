package simpleSorts;

public class BubbleSort {
    public static void process(int[] arr) {
        boolean isComplete;
        int n = arr.length;
        do {
            isComplete = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];  // SWAP VALUES
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isComplete = false;
                }
            }
            n--;
        } while (!isComplete);
    }
}
