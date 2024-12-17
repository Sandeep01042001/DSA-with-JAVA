import java.util.Scanner;

public class ZTranspose {
    public static void ZTraversal(int n, int[][] matrix) {
        int[][] transpose = new int[n][n];
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        
        // Step 2: Z traversal of the transposed matrix
        
        // 1. Print the top row (left to right)
        for (int i = 0; i < n; i++) {
            System.out.print(transpose[0][i] + " ");
        }
        
        // 2. Print the secondary diagonal (excluding first and last elements)
        for (int i = 1; i < n - 1; i++) {
            System.out.print(transpose[i][n - i - 1] + " ");
        }
        
        // 3. Print the bottom row (left to right)
        if (n > 1) { // Only print if matrix has more than 1 row
            for (int i = 0; i < n; i++) {
                System.out.print(transpose[n - 1][i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input matrix size
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        
        // Input matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Perform Z Traversal of the transposed matrix
        ZTraversal(n, matrix);
        
        sc.close();
    }
}
