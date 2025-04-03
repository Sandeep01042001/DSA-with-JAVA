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
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    TreeNode infected = null;
    public void treval(TreeNode root, TreeNode pre, int st){
        if(root == null){
            return;
        }
        if(root.val == st){
            infected = root;
        }
        map.put(root,pre);
        treval(root.left, root,st);
        treval(root.right, root, st);
    }
    public int amountOfTime(TreeNode root, int start) {
        treval(root, null, start);
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(infected);
        Set<TreeNode> set = new HashSet<>();
        int time = -1;
        while(q.size()>0){
            int size = q.size();
            while(size-- != 0){
                TreeNode rem = q.removeFirst();
                set.add(rem);
                if(rem.left != null && !set.contains(rem.left)){
                    q.addLast(rem.left);
                }
                if(rem.right != null && !set.contains(rem.right)){
                    q.addLast(rem.right);
                }
                
                TreeNode pn = map.get(rem);
                if(pn != null && !set.contains(pn)){
                    q.addLast(pn);
                }
            }
           time++;
        }
        return time;
    }
}
