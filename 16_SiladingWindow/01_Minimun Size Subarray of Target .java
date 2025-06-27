/* https://leetcode.com/problems/minimum-size-subarray-sum/ */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int pSum = 0;
        for(int i : nums){
            pSum += i;
        }
        if(pSum < target) return 0;


        int i = 0;
        int j = 0;
        int prifixSum = 0;
        int minLen = Integer.MAX_VALUE;;
        while(j<n){
            prifixSum += nums[j];
            while(prifixSum >= target){
                minLen = Math.min(minLen , j-i+1);
                prifixSum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen;
    }
}