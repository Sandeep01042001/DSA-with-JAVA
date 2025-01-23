import java.util.*;  /* https://course.acciojob.com/idle?question=f9ebb6a0-0789-4aea-bc82-d875b1b7ae88 */
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
public class Main {
    public static Node reverse(Node node){
        Node prev = null;
        Node curr = node;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node = prev;
        return node;
    }
    
public static void combine(Node a, Node b, LinkedList ans){
            
        Node temp1 = a;
        Node temp2 = b;
        Node head = new Node(-1);
        Node temp3 = head;

        int carry = 0;
        while(temp1 != null || temp2 != null){
            int val1 = 0;
            if(temp1 != null){
                val1 = temp1.data;
                temp1 = temp1.next;
            }
            int val2 = 0;
            if(temp2 != null){
                val2 = temp2.data;
                temp2 = temp2.next;
            }
            int sum = val1 + val2 + carry;
            int base = sum % 10;
            carry = sum / 10;
            Node nn = new Node(base);
            temp3.next = nn;
            temp3 = nn;

        } 
        if(carry != 0){
            Node nn = new Node(carry);
            temp3.next = nn;
        }
        head = head.next;
        head = reverse(head);
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        for(int i = 0; i < n; i++){
            a.add(input.nextInt());
        }
        for(int i = 0; i < m; i++){
            b.add(input.nextInt());
        }
        a.head = reverse(a.head);
        b.head = reverse(b.head);
        LinkedList ans = new LinkedList();
        combine(a.head, b.head, ans);
        ans.head = reverse(ans.head);
        Node h = ans.head;
        while(h != null){
            System.out.print(h.data + " ");
            h = h.next;
        }
        System.out.println("");
    }
}
