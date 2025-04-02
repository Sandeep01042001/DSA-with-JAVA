
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class Main {
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> ans = tree.bottomView(root);

            for(Integer num:ans)
            System.out.print(num+" ");

            System.out.println();
		}
	}
}
  


class Solution{
    public class Pair{
        Node node;
        int col;
        Pair(Node node, int col){
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList <Integer> bottomView(Node root)

    {
        if(root == null) return new ArrayList<>();
        LinkedList<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.addLast(new Pair(root, 0));
        int level = 1;
        while(q.size()>0){
            int size = q.size();
            while(size-- != 0){
                Pair rem = q.removeFirst();
                int col = rem.col;
                if(map.containsKey(col)){
                   map.put(col, rem.node.data);
                }else{
                   map.put(col, rem.node.data);
                }
                if(rem.node.left != null){
                    q.addLast(new Pair(rem.node.left, col-1));
                }
                 if(rem.node.right != null){
                    q.addLast(new Pair(rem.node.right, col+1));
                }
            }
            level++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
    }
}
