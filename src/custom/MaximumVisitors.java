package custom;

import java.util.Arrays;

/**
 * You have unordered list of pairs of days numbers -
 * days when hotel visitor arrives and leaves ({1, 4}, {6, 8}, {2, 4}, ...).
 * Find out max number of visitors that lived in this hotel at the same time.
 * If at the same day one visitor leaves hotel and another one arrives,
 * we must assume that on this day only one visitor lived in hotel room.
 * <p>
 * (suppose intervals of presence looks like this [x, y) which means inclusive x and exclusive y)
 * <p>
 * Created by NubbY
 */
public class MaximumVisitors {

    public static void main(String[] args) {
        int[][] testInput = {{1, 4}, {2, 3}, {2, 5}, {2, 6}, {6, 7}, {3, 4}};
        MaximumVisitors test = new MaximumVisitors();
        System.out.println(test.maximumVisitors(testInput));
    }

    public int maximumVisitors(int[][] visits) {
        int[] income = new int[visits.length];
        int[] outcome = new int[visits.length];
        for (int i = 0; i < visits.length; i++) {
            income[i] = visits[i][0];
            outcome[i] = visits[i][1];
        }
        Arrays.sort(income);
        Arrays.sort(outcome);

        int currentVisitors = 0;
        int maxVisitors = 0;
        int i = 0, j = 0;
        while (i < visits.length && j < visits.length) {
            if (income[i] < outcome[j]) {
                currentVisitors++;
                maxVisitors = Math.max(maxVisitors, currentVisitors);
                i++;
            } else {
                currentVisitors--;
                j++;
            }
        }
        return maxVisitors;
    }
}
