import java.util.*;
/* https://course.acciojob.com/idle?question=98e9bbba-6f59-4585-a38c-6f9bd3cd972a */
class Solution {
    static int count1(int size, int arr[]) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==0){
                if(arr[mid-1]==1 || mid==0){
                    return mid;
                }else{
                    hi = mid -1;
                }
            }else{
                if(arr[mid+1]==0 || mid == size-1){
                    return mid + 1;
                }else{
                    lo = mid + 1;
                }
            }
        }
        return size;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.count1(n,array));
    }
}
