/**
 * <a href = "https://leetcode.com/problems/largest-rectangle-in-histogram">Problem here.</a>
 * Created by NubbY
 */
public class LargestRectangleInHistogram {


    public static void main(String[] args) {
        int[] testArray = {2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram test = new LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(testArray));
    }

    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int N = heights.length;

        int[] nextLowerLeft = new int[N];
        int[] nextLowerRight = new int[N];

        nextLowerLeft[0] = -1;
        for (int i = 1; i < N; i++) {
            int curr = i - 1;
            while (curr >= 0 && heights[curr] >= heights[i]) {
                curr = nextLowerLeft[curr];
            }
            nextLowerLeft[i] = curr;
        }

        nextLowerRight[N - 1] = N;
        for (int i = N - 2; i >= 0; i--) {
            int curr = i + 1;
            while (curr < N && heights[curr] >= heights[i]) {
                curr = nextLowerRight[curr];
            }
            nextLowerRight[i] = curr;
        }

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, (nextLowerRight[i] - nextLowerLeft[i] - 1) * heights[i]);
        return max;
    }
}
