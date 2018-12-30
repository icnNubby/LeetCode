/**
<a href = "https://leetcode.com/problems/merge-two-binary-trees"> Problem here. </a>
*/
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return t2;
        }    
        if (t2 == null && t1 != null) {
            return t1;
        }    
        if (t1 == null && t2 == null) {
            return null;
        }
        t1.val = t1.val + t2.val;
        t1.right = mergeTrees(t1.right, t2.right);
        t1.left = mergeTrees(t1.left, t2.left);
        return t1;
    }
}
