import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * <a href = "https://leetcode.com/problems/minimum-time-difference/">Problem here.</a>
 * Created by NubbY
 */
public class MinimumTimeDifference {

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("23:57");
        testList.add("00:00");
        testList.add("22:56");
        testList.add("02:48");
        MinimumTimeDifference test = new MinimumTimeDifference();
        System.out.println(test.findMinDifference(testList));
    }

    private int minutesElapsedFromMidnight(String time) {
        StringTokenizer tk = new StringTokenizer(time, ":");
        int hours = Integer.parseInt(tk.nextToken());
        int minutes = Integer.parseInt(tk.nextToken());
        return hours * 60 + minutes;
    }

    private int calculateDistance(int time1, int time2) {

        if (Math.abs(time2 - time1) > 720) {
            return 1440 - Math.abs(time2 - time1);
        } else {
            return Math.abs(time2 - time1);
        }
    }

    public int findMinDifference(List<String> timePoints) {
        List<Integer> pointsIntegers = new ArrayList<>();
        for (String time : timePoints) {
            pointsIntegers.add(minutesElapsedFromMidnight(time));
        }

        pointsIntegers.sort(null);
        int minDiff = 1440;
        for (int i = 1; i < pointsIntegers.size(); i++) {
            minDiff = Math.min(minDiff, calculateDistance(pointsIntegers.get(i), pointsIntegers.get(i - 1)));
        }
        minDiff = Math.min(minDiff, calculateDistance(pointsIntegers.get(pointsIntegers.size() - 1), pointsIntegers.get(0)));
        return minDiff;
    }
}
