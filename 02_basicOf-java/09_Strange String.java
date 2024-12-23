import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=5bed66aa-ef13-4671-8cc2-9206899c010c */
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0){
            int n = input.nextInt();
            Solution s = new Solution();
            System.out.println(s.strangeString(n));
        }
    }
}

class Solution {
    static String strangeString(int n) {
       Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = (char) ('a' + (i % 26)); 
            if (i % 2 == 0) {
                deque.addFirst(ch); 
            } else {
                deque.addLast(ch); 
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : deque) {
            result.append(ch);
        }
        return result.toString();
    }
}
