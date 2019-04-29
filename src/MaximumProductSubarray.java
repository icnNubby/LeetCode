/**
 * <a href = "https://leetcode.com/problems/maximum-product-subarray/">Problem here.</a>
 * Created by NubbY
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        System.out.println("0 =? " + test.maxProduct(new int[]{0}));
        System.out.println("10 =? " + test.maxProduct(new int[]{2, 5, -1, 0}));
        System.out.println("20 =? " + test.maxProduct(new int[]{2, 5, -1, -2}));
        System.out.println("2 =? " + test.maxProduct(new int[]{2, -1, -1, -2}));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int min = nums[0];
        int max = nums[0];
        int totalMax = max;
        for (int i = 1; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            min = Math.min(nums[i] * min, nums[i]);
            max = Math.max(nums[i] * max, nums[i]);
            totalMax = Math.max(max, totalMax);
        }
        return totalMax;
    }
}
