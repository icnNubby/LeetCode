import java.util.Arrays;


/**
 * <a href = "https://leetcode.com/problems/maximum-width-ramp/">Problem is here.</a>
 */
public class MaximumWidthRamp {

    public static void main(String[] args) {
        int[] A = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        //int[] A = {3, 1, 2, 6, 4, 5};
        MaximumWidthRamp test = new MaximumWidthRamp();
        System.out.println(test.maxWidthRamp(A)); //
    }

    public int maxWidthRamp(int[] A) {

        Integer[] indices = new Integer[A.length];
        for (int i = 0; i < A.length; i++) indices[i] = i;

        Arrays.sort(indices, (Integer o1, Integer o2) -> ((Integer) A[o1]).compareTo(A[o2]));

        int maxRamp = 0;
        int minPrevious = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            minPrevious = Math.min(indices[i], minPrevious);
            maxRamp = Math.max(maxRamp, indices[i] - minPrevious);
        }
        return maxRamp;
    }
}
