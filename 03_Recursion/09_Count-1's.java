import java.util.*;

public class Main {
	static int count1(int n) {
        //Write code here
        if(n==0){
            return 0;
        }
        int lastDig = n%10;
        int remDig = n/10;
        int totalDig = count1(remDig);
        if(lastDig == 1){
            return totalDig + 1;
        }else{
            return totalDig;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count1(n));
        sc.close();
    }

    
}
