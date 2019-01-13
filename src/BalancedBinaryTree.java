/**
 * <a href = "https://leetcode.com/problems/balanced-binary-tree/">Problem here.</a>
 */
public class BalancedBinaryTree {

    private int getMaxDepth(TreeNode root, int currentMax) {
        if (root == null) return currentMax;
        return Math.max(getMaxDepth(root.left, currentMax + 1), getMaxDepth(root.right, currentMax + 1));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getMaxDepth(root.left, 0);
        int right = getMaxDepth(root.right, 0);
        boolean balanced = (Math.abs(left - right) <= 1);
        return (isBalanced(root.right) && isBalanced(root.left) && balanced);
    }
}
