import java.io.*;
import java.util.*;
/* Move one cell to the right (denoted as h1)   https://course.acciojob.com/idle?question=58bc9224-e806-42d4-a9bf-9f0beff3092a
   Move two cells to the right (denoted as h2)
   Move one cell down (denoted as v1)
   Move two cells down (denoted as v2)
   Move one cell diagonally down and right (denoted as d1)
   Move two cells diagonally down and right (denoted as d2) */
public class Main {

    public static ArrayList<String> allPossiblePaths(int n, int m) {
        // write code here
         ArrayList<String> path = new ArrayList<>();
        getPath(0,0, n-1, m-1, "", path);
        return path;
    }
    public static void getPath(int sr, int sc, int dr, int dc, String psf, ArrayList<String> path){
        if(sr == dr && sc == dc){
            path.add(psf);
            return;
        }
        if (sr > dr|| sc > dc ) {
            return;
        }
        getPath(sr, sc+1, dr, dc, psf+"h1",path);
        getPath(sr, sc+2, dr, dc, psf+"h2",path);
        getPath(sr+1, sc, dr, dc, psf+"v1",path);
        getPath(sr+2, sc, dr, dc, psf+"v2",path);
        getPath(sr+1, sc+1, dr, dc, psf+"d1",path);
        getPath(sr+2, sc+2, dr, dc, psf+"d2",path);

    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<String> result = allPossiblePaths(n, m);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }

    }
}
