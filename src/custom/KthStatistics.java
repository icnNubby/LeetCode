package custom;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by NubbY
 */
public class KthStatistics {
    //todo fix

    /*
     L++ -> until arr[L] < arr[pivot]
     R-- -> until arr[R] > arr[pivot]
     */

    public static void main(String[] args) {
        KthStatistics test = new KthStatistics();
        int[] testArr = new int[]{5, 3, 2, 10, 12, 15, 30, -2, 0};
        for (int k = 0; k < testArr.length; k++) {
            test.shuffle(testArr);
            System.out.println(Arrays.toString(testArr));
            System.out.println(k + " - th statistic = " + test.kThStatistic(testArr, k));
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public void shuffle(int[] arr) {
        if (arr.length == 1) return;
        for (int i = 1; i < arr.length; i++) {
            int indexToSwap = new Random().nextInt(arr.length - i);
            int tmp = arr[i - 1];
            arr[i - 1] = arr[i + indexToSwap];
            arr[i + indexToSwap] = tmp;
        }
    }

    public int select(int[] arr, int left, int right, int k) {
        int l = left;
        int r = right;
        int pivot = left + new Random().nextInt(right - left + 1);
        int pivotRemember = arr[pivot];
        while (true) {
            System.out.println("Pivot index = " + pivot + "; Pivot remembered = " + pivotRemember);
            while (l < arr.length && arr[l] < pivotRemember) l++;
            while (r >= 0 && arr[r] >= pivotRemember) r--;
            if (r >= 0 && l < arr.length && l < r) {
                System.out.println("Swapping arr[" + l + "]" + " and arr[" + r + "]");
                if (arr[r] == pivotRemember) {
                    pivot = l;
                } else if (arr[l] == pivotRemember) {
                    pivot = r;
                }
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                System.out.println("Current array = " + Arrays.toString(arr));
                //l++; r--;
            } else {
                break;
            }
        }
        if (pivot > k) {
            System.out.println("Going left " + left + " to " + (pivot - 1));
            System.out.println("Current array = " + Arrays.toString(arr));
            return select(arr, left, pivot - 1, k);
        } else if (pivot < k) {
            System.out.println("Going right" + (pivot + 1) + " to " + right);
            System.out.println("Current array = " + Arrays.toString(arr));
            return select(arr, pivot + 1, right, k);
        } else {
            System.out.println("Found!");
            return arr[k];
        }
    }

    public int kThStatistic(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }
}
