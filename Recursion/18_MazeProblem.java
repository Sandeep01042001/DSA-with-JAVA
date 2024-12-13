import java.io.*;
import java.util.*;
 /*In a single move you are allowed to jump
  1 or more steps horizontally (as h1, h2, .. ), or
   1 or more steps vertically (as v1, v2, ..) or 
   1 or more steps diagonally (as d1, d2, ..).*/
   
   /* Input 2 2
      Output
       h1v1
       v1h1
       d1 */
public class Main {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        //Write your code here
         if(dr<sr || dc<sc){
              return ;
             }
             if(dr == sr && dc == sc){
              System.out.println(psf);
              return;
             }
             
           for(int i=1; sc + i <= dc; i++){
                 printMazePaths(sr, sc +i,dr, dc,psf+"h"+i);
            }
            for(int i=1; sr + i <= dr; i++){
               printMazePaths( sr+i, sc,dr, dc, psf+"v"+i);
            }
            for(int i=1; sc + i<= dc && sr + i <= dr; i++){
                printMazePaths(sr +i, sc +i,dr, dc,psf+"d"+i);
            }
             
             

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}