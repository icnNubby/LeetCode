package custom;

import java.util.Arrays;

/**
 * Created by NubbY
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] testArr = {2, 3, 1, 0, 100, 1};
        BubbleSort test = new BubbleSort();
        System.out.println(Arrays.toString(test.bubbleSort(testArr)));
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
