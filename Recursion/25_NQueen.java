import java.util.*;
/* https://course.acciojob.com/idle?question=bb073cbd-0873-4607-824f-35edc0041c02 */
public class Main {
    public static int totalNQueens(int n) {
        // write code here
        int [] board = new int[n];
        return solve(board, 0, n);

    }
    public static int solve(int [] board, int row, int n){
        if(row==n){
            return 1;
        }
        int count =0;
        for(int col = 0; col<n; col++){
            if(isValid(board, row, col)){
                board[row]= col;
                count += solve(board, row+1,n);
            }
        }
        return count;

    }
    public static boolean isValid(int [] board, int row, int col){
        for(int i=0; i<row; i++){
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    
        System.out.println(totalNQueens(n));
    }
}
