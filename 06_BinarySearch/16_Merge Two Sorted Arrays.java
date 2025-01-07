import java.util.*;
/* https://course.acciojob.com/idle?question=f3c1c3e6-40c4-4714-8c00-895bb970978b */
class Solution {
    public int[] MergeSortArray(int[] A, int[] B) {
          int m = A.length;
        int n = B.length;
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0;

        // Merge both arrays into a temporary array
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = B[j++];
            }
        }

        // Copy remaining elements from A
        while (i < m) {
            temp[k++] = A[i++];
        }

        // Copy remaining elements from B
        while (j < n) {
            temp[k++] = B[j++];
        }

        // Return the merged array
        return temp;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];

        for(int i = 0; i < m; i++) {
            A[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        Solution Obj = new Solution();

        int[] ans = Obj.MergeSortArray(A,B);

        for(int i = 0; i < n + m; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
