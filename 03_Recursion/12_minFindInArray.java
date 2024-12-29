import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(recforMin(arr, 0));
    }

	public static int recforMin(int[] arr, int idx) {
        //Write your code here
        if(idx == arr.length){
            return Integer.MAX_VALUE;
        }
       int min = recforMin(arr, idx +1);
       if(arr[idx] < min){
         return arr[idx];
       }
       return min;
    }
}