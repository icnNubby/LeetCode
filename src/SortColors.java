import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/sort-colors/">Problem here.</a>
 * Inplace O(N) solution
 */

public class SortColors {

    public static void main(String[] args) {
        int[] testArray1 = {1, 0, 0, 0, 1, 1, 2, 1, 1, 2, 2, 0};
        int[] testArray2 = {2, 0, 2, 1, 1, 0};
        SortColors test = new SortColors();
        test.sortColors(testArray1);
        System.out.println(Arrays.toString(testArray1));
        test.sortColors(testArray2);
        System.out.println(Arrays.toString(testArray2));
    }

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int i = 0;

        while (count0 + count1 + count2 <= nums.length - 1) {
            if (nums[i] == 2) {
                nums[i] = nums[nums.length - 1 - count2];
                if (nums[i] == 1) count1 = ((count1 == 0) ? 0 : count1 - 1);
                nums[nums.length - 1 - count2] = 2;
                count2++;
                continue;
            }
            if (nums[i] == 1) {
                nums[i] = nums[nums.length - 1 - count2 - count1];
                nums[nums.length - 1 - count2 - count1] = 1;
                count1++;
                continue;
            }
            if (nums[i] == 0) {
                count0++;
            }
            i++;
        }

    }
}
