import java.util.*;

public class Main { 
   // store paths in ans array
    /* In a single move you are allowed to
    jump 1 or more steps horizontally (as h1, h2, .. ),
    or 1 or more steps vertically (as v1, v2, ..) or 1 
    or more steps diagonally (as d1, d2, ..).*/
    static ArrayList<String> ans = new ArrayList<>();
    static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
            
             if(dr<sr || dc<sc){
              return;
             }
             if(dr == sr && dc == sc){
              ans.add(psf);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        printMazePaths(0, 0, n - 1, m - 1, "");
        Collections.sort(ans);

        for(String path : ans){
            System.out.println(path);
        }
    }
}
