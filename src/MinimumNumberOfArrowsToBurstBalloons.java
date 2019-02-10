import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href = "https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/">Problem here.</a>
 * Created by NubbY
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] testArray = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        MinimumNumberOfArrowsToBurstBalloons test = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(test.findMinArrowShots(testArray));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int current = 1;
        while (current <= points.length) {
            int nextStep = current;
            while (nextStep < points.length && points[current - 1][1] >= points[nextStep][0]) {
                nextStep++;
            }
            count++;
            current = nextStep + 1;
        }
        return count;
    }
}
