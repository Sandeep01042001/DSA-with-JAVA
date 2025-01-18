import java.io.*;  /* https://course.acciojob.com/idle?question=301c6eba-6f82-420a-a8ef-b5601b4cd9e6 */
import java.util.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        int k=sc.nextInt();

        int nums[]=new int[n];

        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        Solution obj=new Solution();
        obj.solve(nums,n,k);

    }
}

class Solution{
    
    static void solve(int nums[],int n,int k)
    {
         int count = 0;
        int oddCount = 0;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1; // To handle subarrays starting at index 0

        for (int num : nums) {
            // Increment oddCount if the number is odd
            if (num % 2 != 0) {
                oddCount++;
            }

            // If we have seen oddCount - k before, it means a subarray ending here has k odd numbers
            if (oddCount >= k) {
                count += prefix[oddCount - k];
            }

            // Increment the prefix count for the current oddCount
            prefix[oddCount]++;
        }

        System.out.print(count);
       
    }
}
