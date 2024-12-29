import java.util.*;

class Solution {
    public void MatTraverseRecur(int[][] mat) {
        // Write your code here
        printMatrix(mat, 0, 0);
    }
    public void printMatrix(int[][] mat, int r, int c){
        if(r >= mat.length){
            return;
        }
        if(c>=mat[r].length){
            System.out.println();
            printMatrix(mat, r+1, 0);
            return;
        }
        System.out.print(mat[r][c] + " ");
        printMatrix(mat, r, c+1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] mat = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
	    Solution Obj = new Solution();
        Obj.MatTraverseRecur(mat);
    }
}
