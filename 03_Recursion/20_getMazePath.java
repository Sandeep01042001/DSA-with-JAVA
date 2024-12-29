import java.util.*;
/*  You can move in only two directions - 1-step horizontal (h) and 1-step vertical (v).*/
/* Input 3 3
Output  [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh] */
/*  https://course.acciojob.com/idle?question=2a53222b-7c53-4c9f-af17-549b086a742e */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // Number of rows
        int m = input.nextInt(); // Number of columns
        ArrayList<String> paths = getMazePaths(0, 0, n - 1, m - 1, "");
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        if (sr == dr && sc == dc) {
            ArrayList<String> br = new ArrayList<>();
            br.add(psf);
            return br;
        }
        if (sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        ArrayList<String> group = new ArrayList<>();
        ArrayList<String> hPath = getMazePaths(sr, sc + 1, dr, dc, psf + "h");
        group.addAll(hPath);
        ArrayList<String> vPath = getMazePaths(sr + 1, sc, dr, dc, psf + "v");
        group.addAll(vPath);

        return group; 
    }
}
