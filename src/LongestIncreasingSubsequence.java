/**
 * <a href ="https://leetcode.com/problems/longest-increasing-subsequence/">Problem here.</a>
 * Created by NubbY
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] testArray = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
        System.out.println(test.lengthOfLIS(testArray));
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length <= 1) return nums.length;

        int[] longest = new int[nums.length];

        longest[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, longest[j] + 1);
                }
            }
            longest[i] = max;
        }
        int max = longest[0];
        for (int i = 1; i < nums.length; i++)
            max = Math.max(max, longest[i]);
        return max;
    }
}
