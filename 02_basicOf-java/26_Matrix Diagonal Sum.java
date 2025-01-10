import java.util.*;
/* https://course.acciojob.com/idle?question=a99fcd56-d79b-4397-898f-2dfbf44da6f5 */
class Solution {
    public int diagonalSum(int[][] mat, int n) {
       int sum = 0;

        for (int i = 0; i < n; i++) {
            // Add primary diagonal element
            sum += mat[i][i];

            // Add secondary diagonal element, avoiding double-counting the center element
            if (i != n - i - 1) {
                sum += mat[i][n - i - 1];
            }
        }

        return sum;
}
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.diagonalSum(mat, n));

        sc.close();
    }
}
