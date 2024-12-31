import java.util.*;
/* https://leetcode.com/problems/search-a-2d-matrix/submissions/1493415569/
https://course.acciojob.com/idle?question=e469460a-11cf-480b-b950-02efad208e6b */
public class Main {
    public static boolean SearchA2DMatrix(int[][] arr, int x) {

        int rows = arr.length;
        int cols = arr[0].length;

        int lo = 0;
        int hi = rows * cols -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int row = mid/cols;
            int col = mid % cols;
            if(arr[row][col] == x){
                return true;
            }else if(arr[row][col] < x){
                lo = mid + 1;
            }else{
                hi = mid -1;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(SearchA2DMatrix(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
