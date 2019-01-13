import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/largest-perimeter-triangle/">Problem here.</a>
 */
public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 1};
        LargestPerimeterTriangle test = new LargestPerimeterTriangle();
        System.out.println(test.largestPerimeter(testArray));
    }

    private boolean validate(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i > 1; i--) {
            if (validate(A[i], A[i - 1], A[i - 2])) return A[i] + A[i - 1] + A[i - 2];
        }
        return 0;
    }
}
