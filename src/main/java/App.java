import complexSorts.MergeSort;
import complexSorts.QuickSort;
import simpleSorts.BubbleSort;
import simpleSorts.InsertionSort;
import simpleSorts.SelectionSort;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        int size = 10;
        int[] arrTest1 = new int[size];
        int[] arrTest2 = new int[size];
        int[] arrTest3 = new int[size];
        int[] arrTest4 = new int[size];
        int[] arrTest5 = new int[size];
        for (int i = 0; i < size; i++) {
            arrTest1[i] = getRandomNumber(0, 100);
            arrTest2[i] = arrTest1[i];
            arrTest3[i] = arrTest1[i];
            arrTest4[i] = arrTest1[i];
            arrTest5[i] = arrTest1[i];
        }
        System.out.println("arr1 unsorted: " + Arrays.toString(arrTest1));
        System.out.println("arr2 unsorted: " + Arrays.toString(arrTest2));
        System.out.println("arr3 unsorted: " + Arrays.toString(arrTest3));
        System.out.println("arr4 unsorted: " + Arrays.toString(arrTest4));
        System.out.println("arr5 unsorted: " + Arrays.toString(arrTest5));

        long start = System.nanoTime();
        BubbleSort.process(arrTest1);
        long finish = System.nanoTime();
        long elapseTime = finish - start;
        System.out.println("Bubble Sort running time: " + convertNanoSeconds(elapseTime));

        start = System.nanoTime();
        InsertionSort.process(arrTest2);
        finish = System.nanoTime();
        elapseTime = finish - start;
        System.out.println("Insertion Sort running time: " + convertNanoSeconds(elapseTime));

        start = System.nanoTime();
        SelectionSort.process(arrTest3);
        finish = System.nanoTime();
        elapseTime = finish - start;
        System.out.println("Selection Sort running time: " + convertNanoSeconds(elapseTime));

        start = System.nanoTime();
        MergeSort.process(arrTest4, 0, arrTest4.length - 1);
        finish = System.nanoTime();
        elapseTime = finish - start;
        System.out.println("Merge Sort running time: " + convertNanoSeconds(elapseTime));

        start = System.nanoTime();
        QuickSort.process(arrTest5, 0, arrTest5.length - 1);
        finish = System.nanoTime();
        elapseTime = finish - start;
        System.out.println("Quick Sort running time: " + convertNanoSeconds(elapseTime));

        System.out.println("arr1 sorted: " + Arrays.toString(arrTest1));
        System.out.println("arr2 sorted: " + Arrays.toString(arrTest2));
        System.out.println("arr3 sorted: " + Arrays.toString(arrTest3));
        System.out.println("arr4 sorted: " + Arrays.toString(arrTest4));
        System.out.println("arr5 sorted: " + Arrays.toString(arrTest5));
    }

    private static String convertNanoSeconds(long nanoSecs) {
        long hours = TimeUnit.HOURS.convert(nanoSecs, TimeUnit.NANOSECONDS);
        nanoSecs -= hours * 60 * 60 * 1_000_000_000;
        long minutes = TimeUnit.MINUTES.convert(nanoSecs, TimeUnit.NANOSECONDS);
        nanoSecs -= minutes * 60 * 1_000_000_000;
        long seconds = TimeUnit.SECONDS.convert(nanoSecs, TimeUnit.NANOSECONDS);
        nanoSecs -= seconds * 1_000_000_000;
        long milliseconds = TimeUnit.MILLISECONDS.convert(nanoSecs, TimeUnit.NANOSECONDS);
        return String.format("%d hours : %d minutes : %d seconds : %d milliseconds",
                hours, minutes, seconds, milliseconds);
    }

    /**
     * Gets a random integer in range min, max.
     * @param min inclusive
     * @param max exclusive
     * @return int
     */
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
