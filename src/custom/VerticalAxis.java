package custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given list of 2D points, find out if they have vertical axis of symmetry.
 * Created by NubbY
 */
public class VerticalAxis {

    public static void main(String[] args) {
        VerticalAxis test = new VerticalAxis();
        int[][] points1 = new int[][]{{1, 1}, {2, 2}, {4, 2}, {5, 1}};
        int[][] points2 = new int[][]{{1, 1}, {2, 2}, {4, 2}, {7, 1}};

        System.out.println(test.hasAxis(points1));
        System.out.println(test.hasAxis(points2));
    }

    private boolean checkSymmetryForThatAxis(float xOfAxis, List<Point> points) {
        points.sort(null);
        for (int i = 0; i < points.size() / 2; i++) {
            if ((points.get(points.size() - i - 1).x - xOfAxis) != (xOfAxis - points.get(i).x)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasAxis(int[][] points) {
        HashMap<Integer, List<Point>> mapped = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            if (mapped.get(points[i][1]) == null) {
                mapped.put(points[i][1], new ArrayList<>());
            }
            mapped.get(points[i][1]).add(new Point(points[i][0], points[i][1]));
        }
        List<Point> first = mapped.get(points[0][1]);
        first.sort(null);
        float axis = 0;
        if (first.size() % 2 == 0) {
            axis = (float) (first.get(first.size() / 2 - 1).x + first.get(first.size() / 2).x) / 2;
        } else {
            axis = first.get(first.size() / 2).x;
        }

        for (int y : mapped.keySet()) {
            if (!checkSymmetryForThatAxis(axis, mapped.get(y))) {
                return false;
            }
        }

        return true;
    }

    class Point implements Comparable<Point> {
        public final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}
