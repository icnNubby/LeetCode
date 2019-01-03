import java.util.Arrays;
import java.util.HashSet;

/**
 * <a href = "https://leetcode.com/problems/numbers-with-same-consecutive-differences/">Problem here.</a>
 */
public class NumbersWithSameConsecutiveDifference {

    private HashSet<Integer> numsSameConsec;
    private int N;
    private int K;

    public static void main(String[] arg) {
        NumbersWithSameConsecutiveDifference test = new NumbersWithSameConsecutiveDifference();
        int[] testArray = test.numsSameConsecDiff(9, 3);
        System.out.println(Arrays.toString(testArray));
    }

    private void fillNumbers(int constructedNum) {
        if ((int) (Math.log10(constructedNum) + 1) == N) {
            numsSameConsec.add(constructedNum);
            return;
        }
        byte lastDigit = (byte) (constructedNum % 10);
        if (lastDigit - K >= 0) fillNumbers(constructedNum * 10 + lastDigit - K);
        if (lastDigit + K <= 9) fillNumbers(constructedNum * 10 + lastDigit + K);
    }

    public int[] numsSameConsecDiff(int N, int K) {
        this.N = N;
        this.K = K;
        numsSameConsec = new HashSet<>();
        if (N == 1) numsSameConsec.add(0);
        for (int i = 1; i < 10; i++) {
            fillNumbers(i);
        }
        int[] out = new int[numsSameConsec.size()];
        int i = 0;
        for (int element : numsSameConsec) out[i++] = element;
        return out;
    }
}
