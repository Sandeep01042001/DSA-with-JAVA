import java.io.*;   /*  https://course.acciojob.com/idle?question=5a9b74ab-5b0d-48ee-9f86-8ea64b016649 */
import java.util.*;
 
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
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    static void unfold(Node head)
    {
          if(head == null && head.next == null){
            return;
          }
          Node fp = head;
          Node sp = head.next;
          Node sh = sp;

          while(sp != null && sp.next != null){
             fp.next = sp.next;
             fp = fp.next;
             sp.next = fp.next;
             sp = fp.next;
          }
          fp.next = null;
          // SecondHalf revers in LinkedList
          sh = reverse(sh);
          // marge two LinkedList
         
         fp.next = sh;
         Node temp = head;
         while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
         } 

    }
    static Node reverse(Node head){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
public class Main {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        Solution Ob = new Solution();
        Ob.unfold(l1.head);
    }
}
