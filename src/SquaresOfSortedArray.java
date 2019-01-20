import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/squares-of-a-sorted-array/">Problem here.</a>
 * O(N) solution;
 * Created by NubbY
 */
public class SquaresOfSortedArray {

    public static void main(String[] args) {

        SquaresOfSortedArray test = new SquaresOfSortedArray();

        int[] testArray = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(test.sortedSquares(testArray)));

        testArray = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(test.sortedSquares(testArray)));

    }

    public int[] sortedSquares(int[] A) {

        int[] out = new int[A.length];

        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                out[i] = A[i] * A[i];
            }
            return out;
        }
        if (A[A.length - 1] <= 0) {
            for (int i = 0; i < A.length; i++) {
                out[A.length - 1 - i] = A[i] * A[i];
            }
            return out;
        }

        int l = 0;
        int r;

        while (true) {
            if ((A[l] < 0 && A[l + 1] > 0) || A[l] == 0) {
                r = l + 1;
                break;
            }
            l++;
        }
        int index = 0;
        while (true) {
            if (r >= A.length) {
                for (int i = l; i >= 0; i--) {
                    out[index] = A[i] * A[i];
                    index++;
                }
                return out;
            }
            if (l < 0) {
                for (int i = r; i < A.length; i++) {
                    out[index] = A[i] * A[i];
                    index++;
                }
                return out;
            }
            if (Math.abs(A[l]) < A[r]) {
                out[index] = A[l] * A[l];
                l--;
            } else {
                out[index] = A[r] * A[r];
                r++;
            }
            index++;
        }
    }
}
