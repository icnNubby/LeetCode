package custom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public List<String> traverseHorizontalWithLevels(TreeNode root) {

        class NodeLeveled {
            private TreeNode node;
            private int level;

            private NodeLeveled(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }

            private int getLevel() {
                return level;
            }

            private TreeNode getNode() {
                return node;
            }
        }

        List<String> out = new ArrayList<>();
        Queue<NodeLeveled> queue = new LinkedList<>();
        queue.add(new NodeLeveled(root, 0));
        StringBuilder sb = new StringBuilder();
        int prevLevel = 0;
        while (!queue.isEmpty()) {
            NodeLeveled currentLeveledNode = queue.poll();
            TreeNode currentNode = currentLeveledNode.getNode();
            int currentLevel = currentLeveledNode.getLevel();
            if (currentNode.left != null) queue.add(new NodeLeveled(currentNode.left, currentLevel + 1));
            if (currentNode.right != null) queue.add(new NodeLeveled(currentNode.right, currentLevel + 1));

            if (currentLevel > prevLevel) {
                sb.delete(sb.length() - 2, sb.length());
                out.add(sb.toString());
                sb.delete(0, sb.length());
                prevLevel = currentLevel;
            }
            sb.append(currentNode.val).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        out.add(sb.toString());

        return out;
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
