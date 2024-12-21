import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=5458dd01-181b-42a6-a54b-5ccf40a48e73
Example 1
Input
6 5 
4 5 0 -2 -3 1
Output
7
Explanation
There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1]
[5]
[5, 0]
[5, 0, -2, -3]
[0]
[0, -2, -3]
[-2, -3]*/
public class Main {

    public static int subarrayDivisbleByK(int nums[], int n, int k){
        Map<Integer, Integer> prefixModCount = new HashMap<>();
        prefixModCount.put(0, 1);
        int count = 0; 
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num; 
            int mod = (prefixSum % k + k) % k;
            count += prefixModCount.getOrDefault(mod, 0);
            prefixModCount.put(mod, prefixModCount.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);        
        System.out.println('\n');
    }
}
