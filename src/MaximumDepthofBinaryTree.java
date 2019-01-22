/**
 * <a href = "https://leetcode.com/problems/maximum-depth-of-n-ary-tree/">Problem here.</a>
 * Created by NubbY
 */
public class MaximumDepthofBinaryTree {
    private int countDepth(Node root, int currentDepth) {
        if (root == null) return currentDepth;
        int maxDepth = currentDepth;
        for (Node child : root.children) {
            maxDepth = Math.max(countDepth(child, currentDepth + 1), maxDepth);
        }
        return maxDepth;
    }

    public int maxDepth(Node root) {
        return root == null ? 0 : countDepth(root, 1);
    }
}
