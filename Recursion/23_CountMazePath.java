/*https://course.acciojob.com/idle?question=a5508cd1-b8dc-4bf3-a968-b42a488c3265*/
/* Only two moves are allowed 1-step horizontal to the right and 1-step vertically down. */
import java.io.*;
import java.util.*;

public class Main{
    static int countMazePath(int dr, int dc, int sr, int sc)
    {
        if(dr<sr || dc<sc){
        return 0;
       }
       if(dr == sr && dc == sc){
        return 1;
       }
       int val = countMazePath(dr, dc,  sr, sc +1);
       int val2 = countMazePath(dr, dc, sr+1, sc);

       return val + val2;
    }
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        n = sc.nextInt();
        m = sc.nextInt();
        System.out.println(countMazePath(n, m, 1,1));
    }
}
