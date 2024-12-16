import java.util.*;
/* https://course.acciojob.com/idle?question=842a9b40-7830-4e90-bd25-bffc65a02055 */
/* Input
3 3   2D array size
0 1 1
0 1 1
1 0 1
1 1 2  start row and col and fill color
Output

0 2 2
0 2 2
1 0 2 */
public class Main {
    static boolean [][]arr;
    public static void FloodFill(int[][] w, int x, int y, int c) {
        // write code here
        int prevColor = w[x][y];
       
        if(prevColor == c){
            return;
        }
        arr = new boolean [w.length][w[0].length];
        floodcolor(w, x, y, prevColor, c);
        
    }
    public static void floodcolor (int [][] image , int sr, int sc, int prevColor, int currColor){
         if(sr<0 ||sr >= image.length ||sc<0|| sc >= image[0].length){
           return;
         }

        if(image[sr][sc] != prevColor || arr[sr][sc]){
           return;
         }
         
         arr[sr][sc] = true;
         
         floodcolor(image, sr, sc + 1, prevColor,currColor); // Right
         floodcolor(image, sr + 1, sc, prevColor,currColor); // Down
         floodcolor(image, sr, sc - 1, prevColor,currColor); // Left
         floodcolor(image, sr - 1, sc, prevColor,currColor); // Up
         image[sr][sc] = currColor;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] w = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; ++j)
                w[i][j] = sc.nextInt();
        }
        int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
	    FloodFill(w, x, y, c);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(w[i][j] + " ");
            System.out.println();
        }
    }
}
