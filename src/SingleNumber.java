/**
 * <a href = "https://leetcode.com/problems/single-number/">Problem here.</a>
 * Created by NubbY
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int out = nums[0];
        for (int i = 1; i < nums.length; i++) out ^= nums[i];
        return out;
    }
}
