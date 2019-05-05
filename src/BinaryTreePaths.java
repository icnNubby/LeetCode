import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/binary-tree-paths/">Problem here.</a>
 * Created by NubbY
 */
public class BinaryTreePaths {

    public void traverse(TreeNode root, String path, List<String> out) {
        if (root == null) {
            return;
        }
        String addition = path.isEmpty() ? Integer.toString(root.val) : "->" + root.val;
        if (root.left == null && root.right == null) {
            out.add(path + addition);
        }
        if (root.left != null) {
            traverse(root.left, path + addition, out);
        }
        if (root.right != null) {
            traverse(root.right, path + addition, out);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList<>();
        traverse(root, "", out);
        return out;
    }
}
