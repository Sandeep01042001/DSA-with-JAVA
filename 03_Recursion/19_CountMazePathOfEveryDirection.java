import java.util.*;
/*All moves are allowed, i.e. a valid path can consist of
 steps that are horizontal, vertical or diagonal in any direction, 
 except no cell should be repeated twice in the same path. */
 /* https://course.acciojob.com/idle?question=2875c8b1-6a6b-4946-9aed-ce1ac886f2e0 */
public class Main {
    static boolean [][] arr;
    static int pathCount = 0;
    //static ArrayList<String> path = new ArrayList<>();
    static int countAllPath(int n, int m)
    {
        //Write your code here
        arr = new boolean [n][m];
        countMpath(0,0,n,m);
        return pathCount;

    }
    public static void countMpath(int sr, int sc, int dr, int dc){
       if(sr==dr-1 && sc==dc-1){
         pathCount++;
         return;
       }
       if(sr<0 || sc <0 || sr>=dr || sc >= dc){
        return;
       }
       if(arr[sr][sc] == true){
        return;
       }
       arr[sr][sc] = true;
       countMpath(sr + 1, sc, dr, dc);
       countMpath(sr - 1, sc, dr, dc);
       countMpath(sr, sc +1, dr, dc);
       countMpath(sr, sc-1, dr, dc);
       countMpath(sr + 1, sc+1, dr, dc);
       countMpath(sr + 1, sc-1, dr, dc);
       countMpath(sr-1, sc+1, dr, dc);
       countMpath(sr - 1, sc -1, dr, dc);
       arr[sr][sc] = false;
    }

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
}