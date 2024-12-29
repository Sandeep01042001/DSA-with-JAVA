import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);
    }
    static int[] rowDir = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] colDir = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void printKnightsTour(int[][] board, int r, int c, int move) 
    {
        int n = board.length;
        if(move == n*n){
            board[r][c] = move;
            displayBoard(board);
            board[r][c] = 0;
        }
        board[r][c] = move;
        for(int i=0; i<8; i++){
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];
            if(newRow >= 0 && newRow < n && newCol >=0 && newCol <n && board[newRow][newCol] == 0){
                printKnightsTour(board, newRow, newCol, move +1);
            }
        }
        board[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}