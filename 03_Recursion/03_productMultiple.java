import java.util.*;

public class Main {
	static long product(long n){
		//Write code here
        if(n==1){
            return 1;
        }
        long prevMul = product(n-1);
       return n*prevMul;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(product(n));
    }
}