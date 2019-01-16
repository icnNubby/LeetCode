/**
 * <a href = "https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">Problem here.</a>
 */
public class PopulatingNextRightPointersInEachNode {

    private TreeLinkNode inputRoot;

    private TreeLinkNode getTreeNodeByCode(TreeLinkNode root, String code) {
        if (code == null) return null;
        if (code.equals("")) return root;
        StringBuilder sb = new StringBuilder(code);
        if (code.charAt(0) == 'L') {
            sb.deleteCharAt(0);
            return getTreeNodeByCode(root.left, sb.toString());
        } else {
            sb.deleteCharAt(0);
            return getTreeNodeByCode(root.right, sb.toString());
        }
    }

    private String getCodeOfNextNode(String currCode) {
        if (currCode == null || currCode.length() == 0) return null;
        int i = currCode.length() - 1;
        while (i > 0 && currCode.charAt(i) == 'R') i--;
        if (i == 0 && currCode.charAt(i) == 'R') return null;
        StringBuilder sb = new StringBuilder(currCode.substring(0, i));
        sb.append('R');
        while (i < currCode.length() - 1) {
            sb.append('L');
            i++;
        }
        return sb.toString();
    }

    private void traverseAndConnectTree(TreeLinkNode root, String code) {
        if (root != null) {
            root.next = getTreeNodeByCode(inputRoot, getCodeOfNextNode(code));
            traverseAndConnectTree(root.left, code + "L");
            traverseAndConnectTree(root.right, code + "R");
        }
    }

    public void connect(TreeLinkNode root) {
        inputRoot = root;
        traverseAndConnectTree(root, "");
    }

}
