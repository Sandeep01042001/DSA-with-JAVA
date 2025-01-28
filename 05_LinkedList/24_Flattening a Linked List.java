/*Explanation:-  https://course.acciojob.com/idle?question=190b12c6-5a31-436d-8821-bd29626d80ad
The resultant linked list has every node in a single level. 
Given LinkedList : 
5-->10-->19-->28
|    |    |    |
7   20   22   35
|         |    |
8        50   40
|              |
30            45
Sorted LinkedList  : 5 7 8 10 19 20 22 28 30 35 40 45 50  */

import java.util.*;
// Java program for flattening a Linked List
public class Main {

  /* Linked list Node*/
  static class Node {

    int data;
    Node right, down;

    Node(int data) {
      this.data = data;
      right = null;
      down = null;
    }
  }

  static Node flatten(Node root) {
    // your code here
        Node head = travelRightAndMarge(root);
        return head;
  }
  static Node travelRightAndMarge(Node root){
        if(root.right == null){
            return root;
        }
        root.right = travelRightAndMarge(root.right);
        Node fh = margeTwoSortedLL(root, root.right);
        return fh;
  }
  static Node margeTwoSortedLL(Node h1, Node h2){
        Node t1 = h1;
        Node t2 = h2;
        Node h3 = new Node (-1);
        Node t3 = h3;
        
        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                t3.down = t1;
                t3 = t1;
                t1 = t1.down;
            }else{
                t3.down = t2;
                t3 = t2;
                t2 = t2.down;
            }
        }
        h1.right = null;
        h2.right = null;
        if(t1 == null){
            t3.down = t2;
        }
        if(t2 == null){
            t3.down = t1;
        }
        return h3.down;
  }

static void printList(Node head) {
    // your code here
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.down;
    }
    System.out.println();
  }

  public static boolean isCorrect(Node claim) {
    if (claim.right != null) return false;
    Node copy = claim;
    while (copy.down != null) {
      if (copy.down.data < copy.data) return false;
      copy = copy.down;
    }
    return true;
  }

  // Driver's code
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Node ll = new Node(-1), prev1 = null, head = ll;
    for (int i = 0; i < n; i++) {
      int k = sc.nextInt();
      Node prev2 = null, copy = ll;
      while (k-- != 0) {
        int val = sc.nextInt();
        copy.data = val;
        copy.down = new Node(-1);
        prev2 = copy;
        copy = copy.down;
      }
      prev2.down = null;
      ll.right = new Node(-1);
      prev1 = ll;
      ll = ll.right;
    }
    sc.close();
    prev1.right = null;
    Node flattenedNode = flatten(head);
    printList(flattenedNode);
    if (isCorrect(flattenedNode)) System.out.println(
      "yes"
    ); else System.out.println("no");
  }
}
