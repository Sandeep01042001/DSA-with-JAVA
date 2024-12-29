import java.util.*;
/* https://course.acciojob.com/idle?question=5a206680-d1df-4e82-8196-dd13f35ba139 */
public class Main {
    public static void findPosition(int nums[], int n,int target)
    {
        int lo = 0;
        int hi = nums.length-1;
        // First Occernace of Index
        int foi = -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                hi = mid-1;
                foi = mid;
            }else if (nums[mid]< target){
                lo = mid +1;
            }else{
                hi = mid -1;
            }
        }
        lo = 0;
        hi = nums.length-1;
        // Last Occernsce of index 
        int loi = -1;
         while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                lo = mid+1;
                loi = mid;
            }else if (nums[mid]< target){
                lo = mid +1;
            }else{
                hi = mid -1;
            }
           
        }
        int [] ans = {foi, loi};
         for(int i : ans){
            System.out.print(i+" ");
         }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}
