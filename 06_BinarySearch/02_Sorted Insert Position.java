import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=bff80545-9861-4ac9-9c16-e4729299bd09 */
public class Main {

    public static int searchInsert(int[] arr, int key) {
        // Write code here
         int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid]<key){
                lo = mid + 1;
            } else{
                hi = mid -1;
            }
        }
        return lo;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}
