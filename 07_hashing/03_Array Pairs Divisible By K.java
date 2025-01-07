import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=dfd243c0-23e1-4628-b227-5e38da625207 */
class Solution {
    public boolean arrayPairs(int[] arr, int k) {
		// write code here
         int[] remainderCount = new int[k];

        // Count the remainders of each element when divided by k
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handle negative remainders
            remainderCount[remainder]++;
        }

        // Check pairing conditions
        for (int i = 0; i <= k / 2; i++) {
            if (i == 0) {
                // For remainder 0, the count must be even
                if (remainderCount[i] % 2 != 0) {
                    return false;
                }
            } else if (i == k - i) {
                // For cases like k = 6, remainder 3 needs to be even
                if (remainderCount[i] % 2 != 0) {
                    return false;
                }
            } else {
                // General case: remainder i should match remainder k-i
                if (remainderCount[i] != remainderCount[k - i]) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
		k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
    }
}
