import java.util.ArrayList;
import java.util.List;

/***
 * <a href = "https://leetcode.com/problems/leaf-similar-trees/">Problem here.</a>
 */
public class LeafSimularTrees {

    private boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        return root.right == null && root.left == null;
    }

    private void traverseTree(TreeNode root, List<Integer> traverse) {
        if (root == null) return;
        if (isLeaf(root))
            traverse.add(root.val);
        traverseTree(root.left, traverse);
        traverseTree(root.right, traverse);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> traverse1 = new ArrayList<>();
        List<Integer> traverse2 = new ArrayList<>();
        traverseTree(root1, traverse1);
        traverseTree(root2, traverse2);
        return traverse1.equals(traverse2);
    }
}
