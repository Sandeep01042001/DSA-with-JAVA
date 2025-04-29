class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int maxlen = 0;
        for(int ele : set){
            int prev = ele -1;
            if(!set.contains(prev)){
                int len = 1;
                int next = ele + 1;
                while(set.contains(next)){
                    len++;
                    next++;
                }
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
}
