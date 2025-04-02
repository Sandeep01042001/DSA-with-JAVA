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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
       LinkedList<TreeNode> q = new LinkedList<>();
       q.addLast(root);
       int level = 1;
       List<Integer> ans = new ArrayList<>();
       while(q.size()>0){
         int size = q.size();
         TreeNode rem = null;
         while(size-- != 0){
            rem = q.removeFirst();
            if(rem.left != null){
                q.addLast(rem.left);
            }
            if(rem.right != null){
                q.addLast(rem.right);
            }
         }
         ans.add(rem.val);
         level = level + 1;
       }
	   return ans;
    }
}
