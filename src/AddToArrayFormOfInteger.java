import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/add-to-array-form-of-integer/">Problem here.</a>
 * Created by NubbY
 */
public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        int[] testA = {2, 7, 4, 1};
        int testK = 1811;
        List<Integer> out = new AddToArrayFormOfInteger().addToArrayForm(testA, testK);
        for (int digit : out) {
            System.out.print(digit);
        }
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        int remainder = K;
        List<Integer> out = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int digitK = remainder % 10;
            remainder /= 10;
            int digitA = A[i];
            int sumDigit = digitA + digitK;
            if (sumDigit > 9) {
                remainder++;
                sumDigit -= 10;
            }
            out.add(0, sumDigit);
        }
        while (remainder > 0) {
            int digit = remainder % 10;
            remainder /= 10;
            out.add(0, digit);
        }
        return out;
    }
}
