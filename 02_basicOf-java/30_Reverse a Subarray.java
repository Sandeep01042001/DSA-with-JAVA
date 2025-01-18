import java.io.*;  /* https://course.acciojob.com/idle?question=2543bc7d-84b4-47a5-917e-dd6b4da5d31b */
import java.util.*;

class Main{

    static boolean solve(int arr[],int N){
        //Write your code here
         int n = arr.length;
        int start = -1, end = -1;

        // Find the first decreasing segment
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                start = i;
                break;
            }
        }

        // If the array is already sorted
        if (start == -1) {
            return true;
        }

        // Find the last element of the decreasing segment
        for (int i = start; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                end = i;
                break;
            }
        }

        // If end is not updated, set it to the last index
        if (end == -1) {
            end = n - 1;
        }

        // Reverse the subarray from start to end
        reverse(arr, start, end);

        // Check if the array is sorted after reversing
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
	
    public static void main(String args[])throws IOException{    
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        boolean ans=solve(arr,N);
        
        if(ans==true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
