public class TwoSumInputArrayIsSorted {
    public static void main(String[] args) {
        TwoSumInputArrayIsSorted test = new TwoSumInputArrayIsSorted();
        int[] testArray = {-3, -2, -1};
        int[] out = test.twoSum(testArray, -4);
        System.out.print(out[0] + ", " + out[1]);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end)
            if (nums[start] == target)
                return start;
            else
                return -1;
        if (nums[(start + end) / 2] >= target)
            return binarySearch(nums, start, ((start + end) / 2), target);
        else if (nums[(start + end) / 2] < target)
            return binarySearch(nums, (1 + (start + end) / 2), end, target);
        else
            return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        while (i < numbers.length) {
            int pair = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (pair > -1) {
                int[] out = {i + 1, pair + 1};
                return out;
            }
            i++;
        }
        return null;
    }

}
