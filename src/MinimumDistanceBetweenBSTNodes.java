/**
 * <a href = "https://leetcode.com/problems/minimum-distance-between-bst-nodes/">Problem here.</a>
 */
public class MinimumDistanceBetweenBSTNodes {

    private int minValue = Integer.MAX_VALUE;

    private TreeNode rightMost(TreeNode root) {
        if (root == null) return null;
        while (root.right != null) root = root.right;
        return root;
    }

    private TreeNode leftMost(TreeNode root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    private void findMinValue(TreeNode root) {
        if (root == null) return;
        TreeNode rightMost = rightMost(root.left);
        TreeNode leftMost = leftMost(root.right);
        if (rightMost != null) minValue = Math.min(minValue, Math.abs(root.val - rightMost.val));
        if (leftMost != null) minValue = Math.min(minValue, Math.abs(root.val - leftMost.val));
        findMinValue(root.left);
        findMinValue(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        findMinValue(root);
        return minValue;
    }
}
