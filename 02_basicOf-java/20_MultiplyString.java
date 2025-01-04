import java.util.*;  /* https://course.acciojob.com/idle?question=cbe3531f-3602-4e26-92cc-d46e11575828 */
import java.lang.*;
import java.math.BigInteger;
import java.io.*;

class solution
{
     public static String multiply(String A, String B) {
         if (A.length() == 0 || B.length() == 0) {
            return "0";
         }
        BigInteger number1 = new BigInteger(A);
        BigInteger number2 = new BigInteger(B);
        BigInteger result = number1.multiply(number2);
        return result.toString();
    }
}
class Main {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  String A = sc.nextLine();
	  String B = sc.nextLine();
	  
    System.out.println(solution.multiply(A,B));
		
	}
}
