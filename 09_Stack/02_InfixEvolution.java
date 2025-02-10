import java.io.*;
import java.util.*;    /*https://course.acciojob.com/idle?question=9c94428f-1965-4a4b-b4be-969a7cbc250e */
/*
 Input
((2+((6*4)/8))-3)
Output
2
 */


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution ob = new Solution();
        ob.evaluate(exp);
    }
}

class Solution {
    public void evaluate(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int acsii = (int) ch;
            if (acsii >= 48 && acsii <= 57) {
                val.push(acsii - 48);
            } else if (op.size() == 0 || ch == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while(op.peek() != '('){
                   int v2 = val.pop();
                   int v1 = val.pop();
                  if (op.peek() == '+')
                      val.push(v1 + v2);
                  if (op.peek() == '-')
                      val.push(v1 - v2);
                  if (op.peek() == '*')
                     val.push(v1 * v2);
                  if (op.peek() == '/')
                     val.push(v1 / v2);
                     op.pop();
                 }
                 op.pop();
            } else {
                if (ch == '+' || ch == '-') {
                    if (op.peek() != '(') {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '+')
                            val.push(v1 + v2);
                        if (op.peek() == '-')
                            val.push(v1 - v2);
                        if (op.peek() == '*')
                            val.push(v1 * v2);
                        if (op.peek() == '/')
                            val.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '*')
                            val.push(v1 * v2);
                        if (op.peek() == '/')
                            val.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    } else {
                        op.push(ch);
                    }
                }
            }
        }
        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '+')
                val.push(v1 + v2);
            if (op.peek() == '-')
                val.push(v1 - v2);
            if (op.peek() == '*')
                val.push(v1 * v2);
            if (op.peek() == '/')
                val.push(v1 / v2);
            op.pop();
        }
        System.out.print(val.peek());
    }
}
