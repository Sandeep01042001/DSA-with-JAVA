/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int LTL_max = Integer.MIN_VALUE;
    public int maxPath (TreeNode root){
        if(root == null){
            return 0;
        }
        
        int NTL_left = Math.max(0,maxPath(root.left));
        int NTL_right = Math.max(0,maxPath(root.right));

       LTL_max = Math.max(LTL_max, NTL_left + NTL_right + root.val);

        return Math.max(NTL_left, NTL_right)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int max = maxPath(root);
        return LTL_max;
    }
}
