/*Rearrange Even Odd Nodes
  Input   https://course.acciojob.com/idle?question=120fb058-e4aa-4c50-8fd9-1bc34055d0de
  5
  1 2 3 4 5
  Output
  2 4 1 3 5*/
import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) {
        if (head == null && tail == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    void printAndTraverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node rearrangeList(Node head) {
        if (head == null || head.next == null) return head;

        Node eH = null, eT = null; // To track even nodes
        Node oH = null, oT = null;   // To track odd nodes
        Node curr = head;
        while (curr != null) {
            if (curr.val % 2 == 0) { // Even node
                if (eH == null) {
                    eH = eT = curr;
                } else {
                    eT.next = curr;
                    eT = eT.next;
                }
            } else { // Odd node
                if (oH == null) {
                    oH = oT = curr;
                } else {
                    oT.next = curr;
                    oT = oT.next;
                }
            }
            curr = curr.next;
        }
        if (eT != null) {
            eT.next = oH; 
        }
        if (oT != null) {
            oT.next = null; 
        }
        return eH != null ? eH : oH;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }

        Solution Obj = new Solution();
        head = Obj.rearrangeList(head);
        llist.printAndTraverse(head); // Print the list after rearranging
        sc.close();
    }
}
