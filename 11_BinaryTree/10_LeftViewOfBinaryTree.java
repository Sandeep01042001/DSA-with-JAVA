import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        LinkedList<Node> q = new LinkedList<>();
        Deque<Integer> dq = new LinkedList<>();
        q.addLast(root);
        while(q.size()>0){
            int size = q.size();
            while(size-- != 0){
                Node rem = q.removeFirst();
                dq.addLast(rem.val);
                if(rem.left != null){
                    q.addLast(rem.left);
                }
                if(rem.right != null){
                    q.addLast(rem.right);
                }
            }
            int val = dq.removeFirst();
            System.out.print(val+" ");
            while(dq.size()>0){
                int remove = dq.removeFirst();
            }
        }
    }
    
}
