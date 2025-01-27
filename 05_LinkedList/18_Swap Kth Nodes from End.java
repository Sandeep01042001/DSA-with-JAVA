import java.util.*; /*https://course.acciojob.com/idle?question=bce0e6c5-34b2-4d11-a9f2-ec6e370d0196*/
import java.io.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node curr = head;
        while(curr.next != null)
            curr = curr.next;
        curr.next = new_node;
    }
}

class Solution{
	Node swapkthnode(Node head, int num, int K)
    {
        //Write your code here
        Node curr = head;
        for(int i=1; i<K; i++){
            curr = curr.next;
        }
        Node a = curr;
        Node b = head;
        while(curr != null && curr.next != null){
            curr = curr.next;
            b = b.next;
        }
        int temp = a.data;
        a.data = b.data;
        b.data = temp;

        return head;

    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++){
            int x = input.nextInt();
            list.add(x);
        }
        Solution obj = new Solution();
		list.head = obj.swapkthnode(list.head, n, k);
		Node curr = list.head;
		while(curr != null){
			System.out.print(curr.data + " ");
			curr = curr.next;
	    }
	}
}
