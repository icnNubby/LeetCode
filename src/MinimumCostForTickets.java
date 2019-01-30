import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/minimum-cost-for-tickets/">Problem here.</a>
 * Created by NubbY
 */
public class MinimumCostForTickets {

    public static void main(String[] args) {
        MinimumCostForTickets test = new MinimumCostForTickets();

        int[] testArrayDays = {6, 10, 13, 17, 19, 24, 27, 28};
        int[] testCosts = {3, 16, 65};

        System.out.println(test.mincostTickets(testArrayDays, testCosts));
    }

    private int findMin(int day1, int day7, int day30) {
        return Math.min(day1, Math.min(day7, day30));
    }

    public int mincostTickets(int[] days, int[] costs) {

        List<Integer> daysList = new ArrayList<>();
        for (int day : days) daysList.add(day);

        int[] costsYear = new int[365];
        for (int i = 364; i >= 0; i--) {
            if (daysList.contains(i)) {
                if (i + 1 > 364) {
                    costsYear[i] = findMin(costs[0], costs[1], costs[2]);
                    continue;
                }
                if (i + 7 > 364) {
                    costsYear[i] = findMin(costs[0] + costsYear[i + 1], costs[1], costs[2]);
                    continue;
                }
                if (i + 30 > 364) {
                    costsYear[i] = findMin(costs[0] + costsYear[i + 1], costs[1] + costsYear[i + 7], costs[2]);
                    continue;
                }
                costsYear[i] = findMin(costs[0] + costsYear[i + 1], costs[1] + costsYear[i + 7], costs[2] + costsYear[i + 30]);
            } else {
                if (i < 364) costsYear[i] = costsYear[i + 1];
            }
        }
        return costsYear[0];
    }

}

