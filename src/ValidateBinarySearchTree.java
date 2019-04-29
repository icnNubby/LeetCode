/**
 * <a href = "https://leetcode.com/problems/validate-binary-search-tree/">Problem here.</a>
 * //todo Might be done much better.
 * <p></p>
 * Created by NubbY
 */
public class ValidateBinarySearchTree {

    private Integer findMin(TreeNode root) {
        if (root == null) return null;
        Integer left = findMin(root.left);
        Integer right = findMin(root.right);
        if (left == null && right == null) {
            return root.val;
        } else if (left != null && right == null) {
            return Math.min(left, root.val);
        } else if (left == null) {
            return Math.min(root.val, right);
        } else {
            return Math.min(Math.min(root.val, left), right);
        }
    }

    private Integer findMax(TreeNode root) {
        if (root == null) return null;
        Integer left = findMax(root.left);
        Integer right = findMax(root.right);
        if (left == null && right == null) {
            return root.val;
        } else if (left != null && right == null) {
            return Math.max(left, root.val);
        } else if (left == null) {
            return Math.max(root.val, right);
        } else {
            return Math.max(Math.max(root.val, left), right);
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Integer left = findMax(root.left);
        Integer right = findMin(root.right);
        boolean checkLeft = (left == null) || left < root.val;
        boolean checkRight = (right == null) || right > root.val;
        return (checkLeft && checkRight && isValidBST(root.left) && isValidBST(root.right));
    }
}
