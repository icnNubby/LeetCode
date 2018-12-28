/**
 * <a href = "https://leetcode.com/problems/invert-binary-tree/submissions/"> Problem here. </a>
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode swap = root.left;
        root.left = root.right;
        root.right = swap;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
