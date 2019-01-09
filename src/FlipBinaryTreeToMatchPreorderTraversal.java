import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Broken solution (or quistion, idk, kinda strange problem)
 * <a href ="https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/">Problem here.</a>
 */
public class FlipBinaryTreeToMatchPreorderTraversal {

    private List<Integer> out = new ArrayList<>();
    private Queue<TreeNode> que = new LinkedList<>();

    private boolean checkNode(TreeNode node, int[] voyage, int index) {
        if (node.val == voyage[index]) {
            if (node.left == null && node.right == null && index * 2 >= voyage.length) return true;
            if (node.left != null && node.right != null) {
                if (voyage.length < index * 2 + 1) return false;
            }
            if (node.left != null || node.right != null) {
                if (voyage.length < index * 2) return false;
            }
            int leftValue = 0;
            if (node.left != null) leftValue = node.left.val;

            int rightValue = 0;
            if (node.right != null) rightValue = node.right.val;

            if (leftValue == 0 || rightValue == 0) {
                return (voyage[index * 2] == leftValue || voyage[index * 2] == rightValue);
            }

            if (leftValue == voyage[index * 2] && rightValue == voyage[index * 2 + 1]) return true;

            if (rightValue == voyage[index * 2] && leftValue == voyage[index * 2 + 1]) {
                out.add(node.val);
                int swap = node.left.val;
                node.left.val = node.right.val;
                node.right.val = swap;
                return true;
            }
        }
        return false;
    }


    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        int index = 1;
        int[] voyageForTree = new int[voyage.length + 1];
        System.arraycopy(voyage, 0, voyageForTree, 1, voyage.length);
        while (index < voyage.length) {
            que.add(root);
            while (!que.isEmpty()) {
                TreeNode node = que.poll();
                if (!checkNode(node, voyageForTree, index)) {
                    out.clear();
                    out.add(-1);
                    break;
                } else {
                    que.add(node.left);
                    que.add(node.right);
                    index++;
                }
            }
        }
        return out;
    }
}
