import java.util.*;
/* https://course.acciojob.com/idle?question=72efea8a-6472-4705-af3d-69ada985c057 */ 
class Solution {
    static int countEqualSubarray01(int arr[], int n)
    {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Initial condition for prefix sum

        int prefixSum = 0;
        int count = 0;

        for (int num : arr) {
            // Treat 0 as -1 to balance with 1
            prefixSum += (num == 0) ? -1 : 1;

            // If prefixSum already exists, add its frequency to count
            count += prefixSumMap.getOrDefault(prefixSum, 0);

            // Update the frequency of the prefixSum
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }   

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray01(arr,N));

    }
}
