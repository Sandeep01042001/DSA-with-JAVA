import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=86e96839-008f-44a3-9082-f2bf84d8b64c */
public class Main {
	public static void main(String args[]) {
		// your code here
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}
		int result = countSpecialElements(arr, N);
		System.out.println(result);
	}
	 public static int countSpecialElements(int[] A, int N) {
        // Prefix sums for even and odd indices
        int[] prefixEven = new int[N + 1];
        int[] prefixOdd = new int[N + 1];

        // Fill prefix sums
        for (int i = 0; i < N; i++) {
            prefixEven[i + 1] = prefixEven[i];
            prefixOdd[i + 1] = prefixOdd[i];
            if (i % 2 == 0) {
                prefixEven[i + 1] += A[i];
            } else {
                prefixOdd[i + 1] += A[i];
            }
        }

        int count = 0;

        // Iterate to check if removing an element balances the array
        for (int i = 0; i < N; i++) {
            int evenSum = prefixEven[i] + (prefixOdd[N] - prefixOdd[i + 1]);
            int oddSum = prefixOdd[i] + (prefixEven[N] - prefixEven[i + 1]);

            if (evenSum == oddSum) {
                count++;
            }
        }

        return count;
    }
}
