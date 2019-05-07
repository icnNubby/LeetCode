package custom;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by NubbY
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] testArr = {2, 3, 1, 0, 100, 1, 50, 90, 111, -1, -1, -1};
        QuickSort test = new QuickSort();
        test.quickSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    private void quickSort(int[] testArr) {
        qSort(testArr, 0, testArr.length - 1);
    }

    private void qSort(int[] arr, int left, int right) {
        if (left >= right) return;
        System.out.println("Came into qSort bounds: " + left + " " + right);
        int pivot = left + new Random().nextInt(right - left + 1);
        int l = left;
        int r = right;
        int pivotElement = arr[pivot];
        swap(arr, left, pivot);
        while (true) {
            while (l < right && arr[l] <= pivotElement) l++;
            while (r > left && arr[r] >= pivotElement) r--;
            if (l >= r) break;
            swap(arr, l, r);
        }
        swap(arr, r, left);
        qSort(arr, left, r - 1);
        qSort(arr, r + 1, right);
    }

    private void swap(int[] arr, int i1, int i2) {
        System.out.println("Swap " + i1 + " = " + arr[i1] + " and " + i2 + " = " + arr[i2]);
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
        System.out.println(Arrays.toString(arr));
    }

}
