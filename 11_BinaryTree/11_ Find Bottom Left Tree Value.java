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
    // int result = 0;
    // int maxLevel = Integer.MIN_VALUE;
    // public void solve(TreeNode root,int level){
    //     if(root == null){
    //         return;
    //     }
    //      if(level > maxLevel){
    //         maxLevel = level;
    //         result = root.val;
    //     }
    //     solve(root.left, level+1);
    //     solve(root.right, level+1);
    // }
    public int findBottomLeftValue(TreeNode root) {
         
        // int max = Integer.MIN_VALUE;
        // solve(root, 0);
        // return result;

        LinkedList<TreeNode> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();

        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-- != 0){
                TreeNode rem = q.removeFirst();
                dq.addLast(rem.val);
                if(rem.right != null) q.addLast(rem.right);
                if(rem.left != null) q.addLast(rem.left);
                
            }
            
        }
        int ans = dq.removeLast();
        return ans;
    }
    
}
