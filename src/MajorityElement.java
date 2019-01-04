/**
 * <a href = "https://leetcode.com/problems/majority-element"> Problem here.</a>
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        MajorityElement test = new MajorityElement();
        System.out.println(test.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        Integer majority = null;
        int majorityCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majorityCount == 0) {
                majority = nums[i];
                majorityCount++;
            } else {
                if (majority != nums[i])
                    majorityCount--;
                else
                    majorityCount++;
            }
        }
        return majority;
    }

}
