import java.util.*;
/* https://course.acciojob.com/idle?question=0be73469-8af8-4cd5-98c7-c9be1a5a4deb */
class Solution {
    public void printMultiplication(int[][] A,int[][] B,int N) {
       
        int[][] result = new int[N][N];

        // Multiply matrices A and B
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

         for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
         }
        
   }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
		while(t-- > 0)
		{
        int n;
        n = sc.nextInt();
        int[][] matrix1 = new int[n][n];
        int[][] matrix2 = new int[n][n];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix1[i][j] = sc.nextInt();
                
                for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix2[i][j] = sc.nextInt();
                
        Solution Obj = new Solution();
        Obj.printMultiplication(matrix1,matrix2,n);
		}
        sc.close();
    }
}
