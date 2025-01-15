import java.util.*;
/* https://course.acciojob.com/idle?question=820babd6-75fe-4d0a-be01-4e025fd055b4 */
class Accio {
    static long MatrixDiagonalProduct(int n, int[][] matrix) {
        long product = 1;

        for (int i = 0; i < n; i++) {
            // Multiply primary diagonal element
            product *= matrix[i][i];

            // Multiply secondary diagonal element, if not overlapping with primary diagonal
            if (i != n - i - 1) {
                product *= matrix[i][n - i - 1];
            }
        }

        return product;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = sc.nextInt();
            }
        }

        Accio obj = new Accio();
        long result = obj.MatrixDiagonalProduct(n, matrix);
        System.out.println(result);
    }
}
