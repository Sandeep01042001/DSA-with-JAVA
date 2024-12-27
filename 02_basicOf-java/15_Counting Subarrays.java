import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=6c09445f-e02e-425e-90fc-b7780a167177 */
class Solution {
	public static int solve(int[] a, int b) {
     int n = a.length;
        int count = 0;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < n; end++) {
            // Add the current element to the sum
            sum += a[end];

            // Shrink the window from the left as long as the sum is greater than or equal to B
            while (sum >= b && start <= end) {
                sum -= a[start];
                start++;
            }

            // Count subarrays ending at the current index
            count += (end - start + 1);
        }

        return count;
 }
}

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
	    
    	int n = sc.nextInt();
    	int[] A = new int[n];
    	for(int i=0;i<n;i++)
        A[i] = sc.nextInt();
        int B = sc.nextInt();
        Solution Obj= new Solution();
        System.out.println(Obj.solve(A, B));
	
    }
}
