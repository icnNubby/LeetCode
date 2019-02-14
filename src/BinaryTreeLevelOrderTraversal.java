import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/binary-tree-level-order-traversal/">Problem here.</a>
 * Created by NubbY
 */
public class BinaryTreeLevelOrderTraversal {
    private List<List<Integer>> output = new ArrayList<>();

    private void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (output.size() < level) output.add(new ArrayList<>());
        output.get(level - 1).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 1);
        return output;
    }
}
