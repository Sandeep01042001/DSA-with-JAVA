import java.util.*;

class StackQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helperSt = new Stack<>();

    void Push(int a) {
        if (stack.size() == 0) {
            stack.push(a);
        } else {
            while (stack.size() > 0) {
                helperSt.push(stack.pop());
            }
            stack.push(a);
            while (helperSt.size() > 0) {
                stack.push(helperSt.pop());
            }
        }

    }

    int Pop() {
        return stack.pop();
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = scanner.nextInt();

        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                s.Push(a);
            } else if (queryType == 2) {
                System.out.print(s.Pop() + " ");
            }
        }
    }
}
