/**
 * <a href ="https://leetcode.com/problems/search-in-rotated-sorted-array/">Problem here.</a>
 */
public class SearchInRotatedSortedArray {

    public static void main(String... args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] testSortedNums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(test.binarySearch(testSortedNums, 0, 9, 3));
        System.out.println(test.binarySearch(testSortedNums, 0, 9, -2));

        int[] testRotatedNums = {4, 5, 6, 7, 8, 9, 0, 1, 2, 3,};
        System.out.println(test.search(testRotatedNums, 3));
        System.out.println(test.search(testRotatedNums, -2));

        int[] testRotatedNums2 = {1, 2};
        System.out.println(test.search(testRotatedNums2, 2));

        int[] testRotatedNums3 = {};
        System.out.println(test.search(testRotatedNums3, 2));

    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end)
            if (nums[start] == target)
                return start;
            else
                return -1;

        if (nums[(start + end) / 2] > target)
            return binarySearch(nums, start, (start + end) / 2, target);
        else if (nums[(start + end) / 2] < target)
            return binarySearch(nums, (start + end) / 2 + 1, end, target);
        else
            return (start + end) / 2;
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (end == -1) return -1;
        if ((end == 0) || (nums[0] < nums[nums.length - 1])) return binarySearch(nums, start, end, target);

        while (start != end - 1) {
            if (nums[(start + end) / 2] > nums[end])
                start = (start + end) / 2;
            else
                end = (start + end) / 2;
        }
        if (target >= nums[0]) return binarySearch(nums, 0, start, target);
        else return binarySearch(nums, end, nums.length - 1, target);

    }
}
