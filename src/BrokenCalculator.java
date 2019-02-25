/**
 * <a href = "https://leetcode.com/problems/broken-calculator/">Problem here.</a>
 * Created by NubbY
 */
public class BrokenCalculator {
    public static void main(String[] args) {
        int testX = 10;
        int testY = 130;
        System.out.print(new BrokenCalculator().brokenCalc(testX, testY));
    }

    public int brokenCalc(int X, int Y) {
        int result = 0;
        while (Y > X) {
            if (Y % 2 == 0) {
                Y /= 2;
            } else {
                Y++;
            }
            result++;
        }
        return X - Y + result;
    }
}
