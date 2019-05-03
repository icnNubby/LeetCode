package custom;

import java.util.Arrays;

/**
 * Created by NubbY
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] testArr = {2, 3, 1, 0, 100, 1};
        InsertionSort test = new InsertionSort();
        System.out.println(Arrays.toString(test.insertionSort(testArr)));
    }

    private int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }
}
