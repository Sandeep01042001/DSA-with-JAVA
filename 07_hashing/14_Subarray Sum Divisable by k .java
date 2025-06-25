/*https://leetcode.com/problems/subarray-sums-divisible-by-k/description/*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int pSum = 0;
        for(int ele : nums){
            pSum = (pSum + ele)%k;
            if(pSum < 0){
                pSum += k;
            }
            count += map.getOrDefault(pSum, 0);
            map.put(pSum, map.getOrDefault(pSum, 0)+1);
        }
        return count;
    }
}
