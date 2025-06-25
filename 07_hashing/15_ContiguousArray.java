/*https://leetcode.com/problems/contiguous-array/description/*/
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pSum = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            int ele = nums[i];
            if(ele == 0){
                pSum += -1;
            }else{
                pSum += 1;
            }
            int len = -1;
            if(map.containsKey(pSum)){
                int idx = map.get(pSum);
                len = i-idx;
                maxLen = Math.max(maxLen, len);
            }else{
                map.put(pSum, i);
            }
        }
        return maxLen;
    }
}
