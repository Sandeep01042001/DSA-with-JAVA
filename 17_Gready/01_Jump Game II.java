 /*https://leetcode.com/problems/jump-game-ii/ */
 
 class Solution {
    public int jump(int[] nums) {
        
        int currReach = 0;
        int maxReach = 0;
        int jumpCount = 0;

        for(int i=0; i<nums.length-1; i++){
            int hight = nums[i];
            if(i + hight > maxReach){
                maxReach = i + hight;
            }
            if(i == currReach){
                jumpCount++;
                currReach = maxReach;
            }
        }

        return jumpCount;
    }
}