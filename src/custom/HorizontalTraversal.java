package custom;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Traverse binary tree horizontally.
 * Created by NubbY
 */
public class HorizontalTraversal {
    public void traverseHorizontal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
            String delim = queue.isEmpty() ? "" : ", ";
            sb.append(currentNode.val).append(delim);
        }
        System.out.println(sb.toString());
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
