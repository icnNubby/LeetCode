import java.util.LinkedList;
import java.util.List;

/**
 * <a href = " https://leetcode.com/problems/unique-binary-search-trees-ii/">Problem here.</a>
 * <p></p>
 * Created by NubbY
 */
public class UniqueBinarySearchTrees2 {

    private List<TreeNode> generateNodes(int start, int finish) {
        List<TreeNode> out = new LinkedList<>();
        if (start > finish) {
            out.add(null);
            return out;
        } else {
            for (int i = start; i < finish; i++) {
                List<TreeNode> leftSubtrees = generateNodes(start, i - 1);
                List<TreeNode> rightSubtrees = generateNodes(i + 1, finish);
                for (int j = 0; j < leftSubtrees.size(); j++) {
                    for (int k = 0; k < rightSubtrees.size(); k++) {
                        TreeNode current = new TreeNode(i);
                        current.left = leftSubtrees.get(j);
                        current.right = rightSubtrees.get(k);
                        out.add(current);
                    }
                }
            }
            return out;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generateNodes(1, n);
    }

}
