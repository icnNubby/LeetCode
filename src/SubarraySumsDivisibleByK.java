/**
 * <a href = "https://leetcode.com/problems/subarray-sums-divisible-by-k/">Problem here.</a>
 */
public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        SubarraySumsDivisibleByK test = new SubarraySumsDivisibleByK();
        int[] testArray = {4, 5, 0, -2, -3, 1};
        int testK = 5;
        int out = test.subarraysDivByK(testArray, testK);
        System.out.println(out);
    }

    public int subarraysDivByK(int[] A, int K) {
        int outcome = 0;
        int[] P = new int[A.length + 1];
        for (int i = 0; i < A.length; i++)
            P[i + 1] = P[i] + A[i];

        int[] count = new int[K];
        for (int i = 0; i < P.length; i++)
            count[(P[i] % K + K) % K]++;

        for (int i = 0; i < K; i++)
            outcome += (count[i] * (count[i] - 1)) / 2;

        return outcome;
    }
}
