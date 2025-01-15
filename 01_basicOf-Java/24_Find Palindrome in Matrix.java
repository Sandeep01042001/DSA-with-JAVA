/* https://course.acciojob.com/idle?question=767e82d2-2a32-481e-88f3-c4d78ffdbfc3  */

import java.io.*;
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][]a = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        Solution ob=new Solution();
        String ans = ob.findPalindrome(a, m,n);
        System.out.println(ans);
        
    }
}


class Solution{
    
    String findPalindrome(int [][]arr, int m,int n){
        for (int col = 0; col < n; col++) {
            if (isPalindromeColumn(arr, m, col)) {
                return col + " COL";
            }
        }

        // Check rows for palindrome
        for (int row = 0; row < m; row++) {
            if (isPalindromeRow(arr, n, row)) {
                return row + " ROW";
            }
        }

        // If no palindrome is found
        return "-1";
    }
     public static boolean isPalindromeRow(int[][] arr, int n, int row) {
        int start = 0, end = n - 1;
        while (start < end) {
            if (arr[row][start] != arr[row][end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
     public static boolean isPalindromeColumn(int[][] arr, int m, int col) {
        int start = 0, end = m - 1;
        while (start < end) {
            if (arr[start][col] != arr[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
