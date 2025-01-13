import java.util.*;  /* https://course.acciojob.com/idle?question=b0a1afc5-a173-4534-ab53-dab64748f4cf */
import java.lang.*;
import java.io.*;

public class Main {
	   public static void main(String args[]) {
	        Scanner input = new Scanner(System.in);
	        String s = input.next();
	           
	        Solution obj= new Solution();
	        
	       
	        System.out.println(obj.removeDuplicates(s));
	    }
}
class Solution{
  
	 public String removeDuplicates(String s) {
	      // Use a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // If the stack is not empty and the top element matches the current character, pop it
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                // Otherwise, push the current character onto the stack
                stack.push(c);
            }
        }

        // Build the final string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
	}
}
