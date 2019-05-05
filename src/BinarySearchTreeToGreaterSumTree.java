/**
 * <a href = "https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/">Problem here.</a>
 * Created by NubbY
 */
public class BinarySearchTreeToGreaterSumTree {

    private int sumTot = 0;

    private void traverse(TreeNode root) {
        if (root.right != null) {
            traverse(root.right);
        }
        sumTot += root.val;
        root.val = sumTot;
        if (root.left != null) {
            traverse(root.left);
        }
    }


    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
}
