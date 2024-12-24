import java.util.*;
import java.io.*;
/* https://course.acciojob.com/idle?question=7649c7a2-17ce-4048-924c-f993e8498c7a */
class Main {
  public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        Solution ob = new Solution();
        System.out.println(ob.addBinary(A,B));
        sc.close();	
	}
}
class Solution{
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;       
        }

        return result.reverse().toString(); 
    }
}
