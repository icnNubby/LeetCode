/**
 * <a href = "https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Problem here.</a>
 */
public class FlattenBinaryTreeToALinkedList {

    private TreeNode connectRightToLeft(TreeNode left, TreeNode right) {
        if (left == null) return null;
        TreeNode leftStart = left;
        while (left.right != null)
            left = left.right;
        left.right = right;
        return leftStart;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        while (!(root.left == null && root.right == null)) {
            if (root.left != null) {
                root.right = connectRightToLeft(root.left, root.right);
                root.left = null;
            }
            root = root.right;
        }
    }

}
