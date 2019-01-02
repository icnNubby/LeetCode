/**
 * <a href = "https://leetcode.com/problems/sum-root-to-leaf-numbers/">Problem here.</a>
 */
public class SumRootToLeafNumbers {

    private int totalSum;

    private void buildPath(TreeNode root, byte[] path) {
        if (root.right == root.left && root.right == null) {
            for (int i = 0; i < path.length; i++)
                totalSum += (path[i] * (int) Math.pow(10, path.length - i - 1));
            totalSum += root.val;
            return;
        }
        byte[] newPath = new byte[path.length + 1];
        System.arraycopy(path, 0, newPath, 0, path.length);
        newPath[path.length] = (byte) root.val;
        if (root.right != null) buildPath(root.right, newPath);
        if (root.left != null) buildPath(root.left, newPath);
    }

    public int sumNumbers(TreeNode root) {
        buildPath(root, new byte[0]);
        return totalSum;
    }
}
