import java.io.*;  /* https://course.acciojob.com/idle?question=f2ee866e-6365-42d6-b9a9-413094c4e5a8 */
import java.util.*;

class Solution{
    public static String reverseWithIntactSpacing(String s){
         Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                stack.push(ch);
            }
        }
        
        // Build the reversed string while keeping spaces intact
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                result.append(' ');
            } else {
                result.append(stack.pop());
            }
        }
        
        return result.toString();
    }
}

class Main{
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s;
            s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.reverseWithIntactSpacing(s));    
        }
    }
}
