import java.util.Arrays;
import java.util.TreeMap;

/**
 * <a href = "https://leetcode.com/problems/k-closest-points-to-origin/">Problem here.</a>
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin test = new KClosestPointsToOrigin();
        int[][] testArray = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        int[][] out = test.kClosest(testArray, K);
        System.out.println(Arrays.deepToString(out));
    }

    public int[][] kClosest(int[][] points, int K) {
        TreeMap<Long, Integer> kClosest = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            kClosest.put((long) Math.pow(points[i][0], 2) + (long) Math.pow(points[i][1], 2), i);
            if (kClosest.size() > K)
                kClosest.pollLastEntry();
        }
        int[][] out = new int[kClosest.size()][2];
        int i = 0;
        for (int point : kClosest.values()) {
            out[i][0] = points[point][0];
            out[i][1] = points[point][1];
            i++;
        }
        return out;
    }
}
