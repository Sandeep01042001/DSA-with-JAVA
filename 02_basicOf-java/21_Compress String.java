import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=dfa8925a-4669-4dba-9269-9156bcfa1b18 */
class Solution {
	public static String compressTheString(String str) {
        //Write your code here
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(str.charAt(str.length() - 1)).append(count);   
        return compressed.toString();     
	}
}


public class Main {
  public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
    String s = input.next();
      
    System.out.println(Solution.compressTheString(s));   
  }
}
