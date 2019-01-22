/**
 * <a href = "https://leetcode.com/problems/distribute-coins-in-binary-tree/">Problem here.</a>
 * Created by NubbY
 */
public class DistributeCoinsInBinaryTree {

    private int total;

    private int getExcess(TreeNode root) {
        if (root == null) return 0;
        int left = getExcess(root.left);
        int right = getExcess(root.right);
        total += Math.abs(left) + Math.abs(right);
        return left + right - 1;
    }

    public int distributeCoins(TreeNode root) {
        getExcess(root);
        return total;
    }
}
