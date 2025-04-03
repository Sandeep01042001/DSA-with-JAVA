/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                TreeNode rem = q.removeFirst();
                if(rem == null){
                    sb.append("# ");
                }else{
                    q.addLast(rem.left);
                    q.addLast(rem.right);
                    sb.append(rem.val+" ");
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String [] nodeVal = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodeVal[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int idx = 1;
        while(q.size()>0){
            TreeNode rem = q.removeFirst();
            TreeNode left = null;
            if(!nodeVal[idx].equals("#")){
                left = new TreeNode (Integer.parseInt(nodeVal[idx]));
                rem.left = left;
                q.addLast(left);
            }
            idx++;
            TreeNode right = null;
            if(!nodeVal[idx].equals("#")){
                right = new TreeNode (Integer.parseInt(nodeVal[idx]));
                rem.right = right;
                q.addLast(right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
