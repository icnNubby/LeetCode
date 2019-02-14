/**
 * <a href = "https://leetcode.com/problems/jump-game/">Problem here.</a>
 * Created by NubbY
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] testArray = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        JumpGame test = new JumpGame();
        System.out.println(test.canJump(testArray));
    }

    private boolean canJump(int[] nums, int pos, int jumpNeeded) {
        boolean possible = !(pos >= 0);
        for (int i = 0; i <= pos; i++) {
            if (nums[i] >= jumpNeeded + (pos - i)) {
                possible = canJump(nums, i - 1, 1);
                return possible;
            }
        }
        return possible;
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        return canJump(nums, nums.length - 2, 1);
    }
}
