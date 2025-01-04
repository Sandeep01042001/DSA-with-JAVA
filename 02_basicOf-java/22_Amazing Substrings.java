import java.util.*;
import java.lang.*;
import java.io.*;
/* https://course.acciojob.com/idle?question=da3be990-745b-4177-ae62-c7412c116991
https://leetcode.com/problems/palindromic-substrings/ */
class Main {

    public static int solve(String S) {
       // your code here
        String vowels = "aeiouAEIOU";
        int count = 0;
        int mod = 10003;
        for (int i = 0; i < S.length(); i++) {
            if (vowels.indexOf(S.charAt(i)) != -1) {
                count = (count + (S.length() - i)) % mod;
            }
        }
        return count;
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
    String S = sc.nextLine();
	  
    System.out.println(solve(S));
		
	}
}
