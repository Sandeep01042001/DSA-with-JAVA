import java.util.*;
import java.lang.*;
import java.io.*;
/* https://course.acciojob.com/idle?question=71891482-69b9-4bd3-a1ae-1945179ee04f */
class Main {
    public static void sqrt(int x) {
        if (x == 0 || x == 1) {
           System.out.print(x); 
        }
        int low = 0, high = x, result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid <= x / mid) { 
                result = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
       System.out.print(result); 
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    sqrt(A);
		
	}
}
