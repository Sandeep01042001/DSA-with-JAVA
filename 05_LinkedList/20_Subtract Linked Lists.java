import java.util.*;  /* https://course.acciojob.com/idle?question=b42a7f80-83b5-416e-aec0-98607b1dc9af */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Main{
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        Node first = new Node(val);
        Node tail = first;
        for(int i=0; i<n-1; i++)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        int m = sc.nextInt();
        val = sc.nextInt();
        Node second = new Node(val);
        tail = second;
        for(int i=0; i<m-1; i++)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        Solution g = new Solution();
        Node res = g.subtract(first, second);
        printList(res);
    }
}

class Solution{   
    static Node subtract(Node l1, Node l2)
    {
        l1 = reverse(l1);
        l2 = reverse(l2);
        if (isSmaller(l1, l2)) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
        }

        Node result = null;
        Node temp = null; 
        int borrow = 0;
        while (l1 != null || l2 != null) {
            int diff = borrow + (l1 != null ? l1.data : 0) - (l2 != null ? l2.data : 0);

            if (diff < 0) {
                diff += 10;
                borrow = -1;
            } else {
                borrow = 0;
            }

            Node newNode = new Node(diff);
            if (result == null) {
                result = newNode;
                temp = result;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        result = reverse(result);
        while (result != null && result.data == 0) {
            result = result.next;
        }
        return result != null ? result : new Node(0);
    }
     public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static boolean isSmaller(Node l1, Node l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if (len1 < len2) return true;
        if (len1 > len2) return false;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) return true;
            if (l1.data > l2.data) return false;
            l1 = l1.next;
            l2 = l2.next;
        }

        return false; 
    }
     public static int getLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
