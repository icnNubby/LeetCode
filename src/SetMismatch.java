import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/set-mismatch">Problem here.</a>
 */
public class SetMismatch {
    public static void main(String... args) {
        SetMismatch test = new SetMismatch();
        int[] testArray = {1, 2, 2, 4, 5};
        System.out.println(Arrays.toString(test.findErrorNums(testArray)));
    }

    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) duplicate = Math.abs(nums[i]) - 1;
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && i != duplicate) {
                int[] out = {duplicate + 1, i + 1};
                return out;
            }
        }
        return null;
    }
}
