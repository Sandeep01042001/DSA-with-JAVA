import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=40ad500f-e244-4123-96fa-fb6300ce8eac */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));
        
    }
}

class Solution {
    static int rowWithMaximumOnes(int arr[][], int n, int m) {
        int col = m-1;
        int row = -1;
        for(int i=0; i<n; i++){
            for(int j=col; j>=0; j--){
                if(arr[i][j]==1){
                    row = i;
                    col--;
                }else{
                    break;
                }
            }
        }
        return row;
    }
}
/* import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        Solution s = new Solution();
        System.out.println(s.rowWithMaximumOnes(arr,n,m));
        
    }
}

class Solution {
    static int rowWithMaximumOnes(int mat[][], int n, int m) {
        int maxRow = -1; 
        int maxOnes = 0;

        for (int i = 0; i < n; i++) {
            int firstOneIndex = binarySearchFirstOne(mat[i], m);
            if (firstOneIndex != -1) { 
                int numOfOnes = m - firstOneIndex; 
                if (numOfOnes > maxOnes) {
                    maxOnes = numOfOnes;
                    maxRow = i;
                }
            }
        }
        return maxRow;
    }
    public static int binarySearchFirstOne(int[] row, int m) {
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                if (mid == 0 || row[mid - 1] == 0) {
                    return mid;
                }
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return -1; 
    }
} */
