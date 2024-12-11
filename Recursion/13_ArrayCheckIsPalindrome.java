import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
       
        System.out.println(isPalindrome(arr,0, n-1));
    }

	public static boolean isPalindrome(int[] arr,int st, int ed) {
           // write your code here
           if(st>=ed){
            return true;
           }
           if(arr[st]==arr[ed]){
            return isPalindrome(arr, st + 1, ed - 1);
           }
           return false;
    }

}