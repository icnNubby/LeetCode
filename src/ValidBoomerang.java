/**
 * <a href = "https://leetcode.com/problems/valid-boomerang/">Problem here.</a>
 * Created by NubbY
 */
public class ValidBoomerang {
    public static void main(String[] args) {
        ValidBoomerang boomerang = new ValidBoomerang();
        int[][] testArray1 = new int[][]{{1, 1}, {2, 3}, {3, 2}};
        System.out.println("True ?= " + boomerang.isBoomerang(testArray1));
        int[][] testArray2 = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println("False ?= " + boomerang.isBoomerang(testArray2));
    }

    public boolean areDistinct(int[][] points) {
        boolean distinct = true;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                distinct = distinct && (points[i][0] != points[j][0] || points[i][1] != points[j][1]);
            }
        }
        return distinct;
    }

    public boolean areInLine(int[][] points) {
        /*
            y = ax + b
            y1 = ax1 + b;
            y2 = ax2 + b;
            (y1 - y2) = a * (x1 - x2)
            a1 = (y1 - y2) / (x1 - x2)
            b1 = y1 - (a * x1);

            a2 = (y2 - y3) / (x2 - x3)
            b2 = y2 - (a * x2)

            (y2 - y3) * (x1 - x2) == (y1 - y2) * (x2 - x3);
            b1 == b2;
            y1 - (a1 * x1) == y2 - (a2 * x2);
            y1 - ((y1 - y2) * x1 / (x1 - x2)) == y2 - ((y2 - y3) * x2 / (x2 - x3))
            (x2 - x3) * (y1 * (x1 - x2) - x1 * (y1 - y2)) == (x1 - x2) * (y2 * (x2 - x3) - x2 * (y2 - y3));

         */
        boolean c1 = ((points[2][1] - points[0][1]) * (points[1][0] - points[2][0]) ==
                (points[1][1] - points[2][1]) * (points[2][0] - points[0][0]));

        boolean c2 = ((points[2][0] - points[0][0]) * (points[1][1] * (points[1][0] - points[2][0]) - points[1][0] * (points[1][1] - points[2][1])) ==
                (points[1][0] - points[2][0]) * (points[2][1] * (points[2][0] - points[0][0]) - points[2][0] * (points[2][1] - points[0][1])));


        return c1 && c2;
    }

    public boolean isBoomerang(int[][] points) {
        return areDistinct(points) && (!areInLine(points));
    }
}
