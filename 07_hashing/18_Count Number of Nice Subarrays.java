class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int oddCount = 0;
        int result = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]%2 != 0){
                oddCount++;
            }
            if(map.containsKey(oddCount - k)){
                result += map.get(oddCount - k);
            }
            map.put(oddCount, map.getOrDefault(oddCount, 0)+1);
        }

        return result;
    }
}
