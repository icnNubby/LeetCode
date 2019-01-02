/**
 * <a href = "https://leetcode.com/problems/univalued-binary-tree/submissions/">Problem here.</a>
 */
public class UnivaluedBinaryTree {
    private int value;

    private boolean check(TreeNode root) {
        if (root == null) return true;
        if (root.val != value) return false;
        return (check(root.left) && check(root.right));
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        value = root.val;
        return check(root);
    }
}
