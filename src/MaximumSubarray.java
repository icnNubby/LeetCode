/**
 * <a href = "https://leetcode.com/problems/maximum-subarray/">Problem here.</a>
 * Created by NubbY
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] testArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaximumSubarray test = new MaximumSubarray();
        System.out.println(test.maxSubArray(testArray));
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for (int i = 0; i < nums.length; i++) {
            currMax = currMax + nums[i];
            max = Math.max(currMax, max);
            if (currMax < 0) currMax = 0;
        }
        return max;
    }
}
