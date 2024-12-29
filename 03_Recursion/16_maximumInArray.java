import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        int result=maxElement(nums, 0);
        System.out.print(result);
    }

    public static int maxElement(int[] arr, int n){
       if (n == arr.length - 1) {
            return arr[n];
        }
        
        // Recursive case: find the maximum in the rest of the array
        int maxInRest = maxElement(arr, n + 1);
        
        // Return the maximum of the current element and max in the rest
        return Math.max(arr[n], maxInRest);
    }
}