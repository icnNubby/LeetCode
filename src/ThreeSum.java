import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/3sum/">Problem here.</a>
 * Created by NubbY
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] testArray = {-1, 0, 1, 2, -1, -4};
        ThreeSum test = new ThreeSum();
        List<List<Integer>> testOut = test.threeSum(testArray);
        for (List<Integer> line : testOut) {
            for (int digit : line)
                System.out.print(digit + " ");
            System.out.println();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int goal = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == goal) {
                    List<Integer> line = new ArrayList<>();
                    line.add(nums[l]);
                    line.add(nums[r]);
                    line.add(nums[i]);
                    out.add(line);
                    while (l < nums.length - 1 && nums[l] == nums[l + 1]) l++;
                    while (r > i && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > goal) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return out;
    }
}
