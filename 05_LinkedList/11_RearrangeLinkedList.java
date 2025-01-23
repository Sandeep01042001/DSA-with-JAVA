import java.util.*;   /* https://course.acciojob.com/idle?question=78bdc5f3-b1ba-4063-a99b-38413ac59785 */
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    static Node head;
    static Node temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            head = null;
            temp = null;
            addToTheLast(a1);

            for (int i = 1; i < n; i++) {
                int data = sc.nextInt();
                addToTheLast(data);
            }
            Solution ans = new Solution();
            Node node = ans.rearrange(head);
            printList(node);
            System.out.println();
        }
    }

    public static void addToTheLast(int data) {
        if (head == null) {
            head = new Node(data);
            temp = head;
            return;
        } else {
            Node new_node = new Node(data);
            temp.next = new_node;
            temp = temp.next;
            return;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution {

    public static Node rearrange(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        // Step 1: Find the middle of the list
        Node slow = node, fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        Node secondHalf = reverseList(slow.next);
        slow.next = null; // Disconnect the first half from the second

        // Step 3: Merge the two halves
        Node firstHalf = node;
        while (secondHalf != null) {
            Node temp1 = firstHalf.next;
            Node temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }

        return node;
    }

    public static Node reverseList(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
