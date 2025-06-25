/*https://leetcode.com/problems/max-consecutive-ones/description/*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int maxOnece = 0,  contiguousOnece = -1;

        while(j < n){
            if(nums[j] != 1){
                contiguousOnece = j - i;
                maxOnece = Math.max(maxOnece, contiguousOnece);
                i = j + 1;
            }
            j++;
        }
        contiguousOnece = j - i;
        maxOnece = Math.max(maxOnece, contiguousOnece);

        return maxOnece;
    }
}
