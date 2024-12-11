import java.io.*;
import java.util.*;

class Main
{

	public static void solve(int n)
    {
        // Your code here
        if(n==0){
            return;
        }
        System.out.print("* ");
        solve(n-1);
        
        
        
    }
	
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
		for(int i=1; i<=n; i++){
            solve(i);
            System.out.println();
        }

    }
}