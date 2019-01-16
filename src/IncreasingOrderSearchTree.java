import java.util.ArrayList;
import java.util.List;

/**
 * Created by NubbY
 * <a href = "https://leetcode.com/problems/increasing-order-search-tree/">Problem here.</a>
 */
public class IncreasingOrderSearchTree {
    private List<Integer> newOrder = new ArrayList<>();

    private void reorder(TreeNode root) {
        if (root == null) return;
        reorder(root.left);
        newOrder.add(root.val);
        reorder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        reorder(root);
        TreeNode newRoot = new TreeNode(0);
        TreeNode current = newRoot;
        for (Integer item : newOrder) {
            current.right = new TreeNode(item);
            current = current.right;
        }
        return newRoot.right;
    }
}
