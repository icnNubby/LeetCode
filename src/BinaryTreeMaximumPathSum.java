/**
 * <a href ="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Problem here.</a>
 */
public class BinaryTreeMaximumPathSum {

    int maxPath = Integer.MIN_VALUE;

    private int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        maxPath = Math.max(maxPath, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxPath;
    }
}
