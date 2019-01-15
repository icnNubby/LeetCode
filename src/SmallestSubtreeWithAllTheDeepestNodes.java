import java.util.HashMap;

/**
 * <a href = "https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/">Problem here.</a>
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    private HashMap<Integer, Integer> depths = new HashMap<>();

    private int countDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int maxDepth = Math.max(countDepth(root.left, depth + 1), countDepth(root.right, depth + 1));
        depths.put(root.val, maxDepth);
        return maxDepth;
    }

    private TreeNode getSmallestSubtree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        if (root.right == null)
            return getSmallestSubtree(root.left);
        if (root.left == null)
            return getSmallestSubtree(root.right);
        if (depths.get(root.left.val).compareTo(depths.get(root.right.val)) == 0)
            return root;
        else if (depths.get(root.left.val).compareTo(depths.get(root.right.val)) > 0)
            return getSmallestSubtree(root.left);
        else return getSmallestSubtree(root.right);
    }


    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        countDepth(root, 0);
        return getSmallestSubtree(root);
    }
}
