/*https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/description/?envType=daily-question&envId=2025-07-18
Example 1:
Input: nums = [3,1,2]
Output: -1
Explanation: Here, nums has 3 elements, so n = 1. 
Thus we have to remove 1 element from nums and divide the array into two equal parts.
- If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
- If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
- If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
The minimum difference between sums of the two parts is min(-1,1,2) = -1. 
approch ->
1.Array ko 3 equal parts me divide karo (n, n, n).
2.First 2n elements me se n smallest elements ka sum nikalo using max-heap.
3.Last 2n elements me se n largest elements ka sum nikalo using min-heap.
4.Har valid split par leftSum - rightSum ka difference nikalo aur minimum difference track karo.*/
class Solution {
    public long minimumDifference(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        long [] prifixSumArr = new long [nums.length];
        long n = nums.length/3;
        long left = 0;
        long right = 0;
        long result = Long.MAX_VALUE;
        
        for(int i=nums.length-1; i>=n; i--){
            minHeap.add(nums[i]);
            right += nums[i];

            if(minHeap.size() > n){
                right -= minHeap.poll();
            }
            if(minHeap.size() == n){
                prifixSumArr[i] = right;
            }
        }

        for(int i=0; i<nums.length-n; i++){
            maxHeap.add(nums[i]);
            left += nums[i];

            if(maxHeap.size() > n){
                left -= maxHeap.poll();
            }
            if(maxHeap.size() == n){
               result = Math.min(result, left - prifixSumArr[i+1]);
            }
        }

        return result;
    }
}
