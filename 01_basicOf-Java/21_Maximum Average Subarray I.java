import java.util.*;
/* https://course.acciojob.com/idle?question=e7dcf084-25db-4c64-8e66-fb8d29cfce6e */
class Solution {
    public double findMaxAverage(int[] nums, int k) {
      int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        int maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return (double) maxSum / k;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int K= sc.nextInt();
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(String.format("%.5f",Obj.findMaxAverage(arr,K)));

    }
}
