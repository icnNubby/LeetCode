/**
 * <a href = "https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/"> Problem here. </a>
 */
public class SortedArrayToBST {

    private TreeNode sortedArrayToBSTindexed(int[] num, int start, int end) {
        TreeNode head;
        if (num.length == 0) return null;
        if (start == end) {
            head = new TreeNode(num[start]);
        } else if (start == end - 1) {
            head = new TreeNode(num[end]);
            head.left = new TreeNode(num[start]);
        } else {
            head = new TreeNode(num[(start + end) / 2]);
            head.left = sortedArrayToBSTindexed(num, start, (start + end) / 2 - 1);
            head.right = sortedArrayToBSTindexed(num, (start + end) / 2 + 1, end);
        }
        return head;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTindexed(nums, 0, nums.length - 1);
    }
}
