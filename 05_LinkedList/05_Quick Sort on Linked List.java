import java.util.*;  /* https://course.acciojob.com/idle?question=f3eddcea-b156-4ab3-b36d-1bcd58a28078 */

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        Node tail = head;

        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            tail.next = new Node(a);
            tail = tail.next;
        }

        Solution solution = new Solution();
        Node sortedHead = solution.quickSort(head);

        printList(sortedHead);
        System.out.println();

        sc.close();
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

class Solution {
    public Node quickSort(Node head) {
        if (head == null || head.next == null) {
            return head; // Base case: 0 or 1 element
        }

        // Partition the list
        Node[] partitioned = partition(head);
        Node lesser = partitioned[0];
        Node equal = partitioned[1];
        Node greater = partitioned[2];

        // Recursively sort lesser and greater parts
        Node sortedLesser = quickSort(lesser);
        Node sortedGreater = quickSort(greater);

        // Combine all parts
        return concatenate(sortedLesser, equal, sortedGreater);
    }

    private Node[] partition(Node head) {
        Node pivot = head; // Choose the first node as the pivot
        Node lesserHead = null, lesserTail = null;
        Node equalHead = null, equalTail = null;
        Node greaterHead = null, greaterTail = null;

        Node current = head;
        while (current != null) {
            if (current.data < pivot.data) {
                if (lesserHead == null) {
                    lesserHead = lesserTail = current;
                } else {
                    lesserTail.next = current;
                    lesserTail = current;
                }
            } else if (current.data > pivot.data) {
                if (greaterHead == null) {
                    greaterHead = greaterTail = current;
                } else {
                    greaterTail.next = current;
                    greaterTail = current;
                }
            } else {
                if (equalHead == null) {
                    equalHead = equalTail = current;
                } else {
                    equalTail.next = current;
                    equalTail = current;
                }
            }
            current = current.next;
        }

        // Terminate the lists
        if (lesserTail != null) lesserTail.next = null;
        if (equalTail != null) equalTail.next = null;
        if (greaterTail != null) greaterTail.next = null;

        return new Node[]{lesserHead, equalHead, greaterHead};
    }

    private Node concatenate(Node lesser, Node equal, Node greater) {
        Node head = null, tail = null;

        // Add lesser list
        if (lesser != null) {
            head = lesser;
            tail = getTail(lesser);
        }

        // Add equal list
        if (equal != null) {
            if (head == null) {
                head = equal;
            } else {
                tail.next = equal;
            }
            tail = getTail(equal);
        }

        // Add greater list
        if (greater != null) {
            if (head == null) {
                head = greater;
            } else {
                tail.next = greater;
            }
        }

        return head;
    }

    private Node getTail(Node node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }
}
