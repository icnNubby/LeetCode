import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/3sum-closest/">Problem here.</a>
 * Created by NubbY
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] testArray = {-1, 2, 1, -4, -5, -10};
        int testGoal = -300;
        ThreeSumClosest test = new ThreeSumClosest();
        System.out.println(test.threeSumClosest(testArray, testGoal));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int goal = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (Math.abs(goal - nums[l] - nums[r]) < closest) {
                    closest = Math.abs(goal - nums[l] - nums[r]);
                    closestSum = nums[i] + nums[r] + nums[l];
                }
                if (closest == 0) {
                    return target;
                } else if (nums[l] + nums[r] > goal) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closestSum;
    }
}
