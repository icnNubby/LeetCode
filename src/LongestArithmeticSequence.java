import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/longest-arithmetic-sequence/">Problem here.</a>
 * <p></p>
 * Created by NubbY
 */
public class LongestArithmeticSequence {

    public static void main(String[] args) {
        LongestArithmeticSequence test = new LongestArithmeticSequence();
        System.out.println(test.longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(test.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(test.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
    }

    public int longestArithSeqLength(int[] A) {

        List<HashMap<Integer, Integer>> dp = new ArrayList<>(A.length);
        for (int i = 0; i < A.length; i++) {
            dp.add(new HashMap<>());
        }
        int out = 0;

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int d = A[j] - A[i];
                HashMap<Integer, Integer> mapJ = dp.get(j);
                HashMap<Integer, Integer> mapI = dp.get(i);

                if (mapI.get(d) != null) {
                    mapJ.put(d, mapI.get(d) + 1);
                    out = Math.max(out, mapJ.get(d));
                } else {
                    mapJ.put(d, 2);
                    out = Math.max(out, 2);
                }
            }
        }

        return out;
    }
}
