import java.util.*;

public class Main {
    public static void main(String[] args) {
   
       // write your code here  
       Scanner scr = new Scanner(System.in);
       int n = scr.nextInt();
       long sum = 0;
        for(int i=1; i<=n; i++){
            sum = sum + i;
        }
        System.out.println(sum);
		
    }

}
