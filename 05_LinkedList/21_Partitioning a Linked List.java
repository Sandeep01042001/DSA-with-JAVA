/*  1. point -> value of lessthen k is left side and gretherthen equal rigth side for same order
    https://course.acciojob.com/idle?question=014a1af9-7d87-4ffb-9762-2ae93a586073
    Input
    6
    1 6 2 5 3 4
    3
    Output
    1 2 6 5 3 4
*/
import java.io.*;
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
    public void partition(Node head, int x) {
        // Your code here
        Node sH = null;
        Node sT = null;
        Node gH = null;
        Node gT = null;

        while(head != null){
            if(head.data < x){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else{
                if(gH == null){
                    gH = head;
                    gT = head;
                }else{
                    gT.next = head;
                    gT = head;
                }
            }
            head = head.next;
        }
        if(gT != null){
            gT.next = null;
        }
        if(sH == null){
             printList(gH);
             return;
        }
        sT.next = gH;
         printList(sH);
         return;
    }
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
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
        int x = sc.nextInt();
        Solution Ob = new Solution();
        Ob.partition(l1.head, x);
    }
}
