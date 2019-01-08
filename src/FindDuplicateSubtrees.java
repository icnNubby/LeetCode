import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href ="https://leetcode.com/problems/find-duplicate-subtrees/">Problem here.</a>
 */
public class FindDuplicateSubtrees {

    private Map<String, TreeNode> map = new HashMap<>();
    private HashMap<TreeNode, Integer> count = new HashMap<>();
    private List<TreeNode> list = new ArrayList<>();

    private String hashOfTreeNode(TreeNode root) {
        if (root == null) return "n";
        return root.val + hashOfTreeNode(root.left) + hashOfTreeNode(root.right);
    }

    private void computeAllHashes(TreeNode root) {
        if (root == null) return;
        String rootHash = hashOfTreeNode(root);
        if (map.containsKey(rootHash)) count.put(map.get(rootHash), count.get(map.get(rootHash)) + 1);
        else {
            map.put(rootHash, root);
            count.put(root, 1);
        }
        computeAllHashes(root.left);
        computeAllHashes(root.right);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        computeAllHashes(root);
        for (TreeNode key : count.keySet())
            if (count.get(key) > 0) list.add(key);
        return list;
    }
}
