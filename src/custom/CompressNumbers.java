package custom;

import java.util.Arrays;

/**
 * You have unordered list of numbers. For example, 5, 0, 1, 2, 4, 9.
 * Compress these numbers and represent them as a string: “0-2, 4-5, 9”.
 * <p>
 * Created by NubbY
 */
public class CompressNumbers {

    public static void main(String[] args) {
        int[] testArr = new int[]{5, 0, 1, 2, 4, 9, 10, 11, -1, -2, -3, -50, 15};
        CompressNumbers test = new CompressNumbers();
        System.out.println(test.compress(testArr));
    }

    private String compress(int[] arr) {
        Arrays.sort(arr);
        int left = 0;
        int number = arr[0]; //0
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            boolean appended = false;
            if (number + 1 != arr[i]) { // 1 == 1;
                if (left == i - 1) {
                    sb.append(number);
                } else {
                    sb.append(arr[left]).append(" - ").append(number);
                }
                left = i;
                appended = true;
            }

            if (i != arr.length - 1 && appended) {
                sb.append(", ");
            }
            number = arr[i]; //number == 1;
        }

        if (left == arr.length - 1) {
            sb.append(", ").append(number);
        } else {
            sb.append(arr[left]).append(" - ").append(number);
        }

        return sb.toString();
    }
}
