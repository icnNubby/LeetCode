/**
 * <a href = "https://leetcode.com/problems/check-completeness-of-a-binary-tree/"> Problem here.</a>
 */
public class CheckCompletenessOfABinaryTree {

    //100 maximum nodes (64 in row 5 + 36 at row 6) maximum 128 + 256 for next level, + 1  for head
    private final Integer[] treeArray = new Integer[385];

    private boolean treeToArray(TreeNode root, int deepLevel, int offset) {
        if (root != null) {
            if (deepLevel > 7) //we cant have complete tree of such depth with <=100 nodes
                return false;
            else {
                treeArray[(int) Math.pow(2, deepLevel) + offset] = root.val;
                return (treeToArray(root.left, deepLevel + 1, offset * 2) &&
                        treeToArray(root.right, deepLevel + 1, offset * 2 + 1));
            }
        } else {
            if (deepLevel > 7)
                return false;
            treeArray[(int) Math.pow(2, deepLevel) + offset] = null;
            return true;
        }
    }

    public boolean isCompleteTree(TreeNode root) {

        boolean success = treeToArray(root, 0, 0);
        //checking if we can build a valid tree from that input

        if (!success) return false;
        boolean foundFirstNull = false;
        for (int i = 1; i < treeArray.length; i++) {
            if (treeArray[i] == null) foundFirstNull = true;
            if (foundFirstNull && treeArray[i] != null) return false;
        }
        return true;
    }
}
