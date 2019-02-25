/**
 * <a href = "https://leetcode.com/problems/cousins-in-binary-tree/">Problem here.</a>
 * Created by NubbY
 */
public class CousinsInBinaryTree {

    private int depthOfValue(TreeNode root, int value, int currentDepth) {
        if (root == null) return -1;
        if (root.val == value) return currentDepth;
        int leftDepth = depthOfValue(root.left, value, currentDepth + 1);
        int rightDepth = depthOfValue(root.right, value, currentDepth + 1);
        return leftDepth == -1 ? rightDepth : leftDepth;
    }

    private TreeNode findRootOf(TreeNode root, int valueToSearch) {
        if (root == null) return null;
        if (root.left != null && root.left.val == valueToSearch) return root;
        if (root.right != null && root.right.val == valueToSearch) return root;
        TreeNode leftSearch = findRootOf(root.left, valueToSearch);
        TreeNode rightSearch = findRootOf(root.right, valueToSearch);
        return leftSearch == null ? rightSearch : leftSearch;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        return depthOfValue(root, x, 0) == depthOfValue(root, y, 0)
                && findRootOf(root, x) != findRootOf(root, y);
    }
}