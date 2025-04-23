class Solution {
    
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(res.isEmpty() || res.get(res.size()-1) < nums[i]){
                res.add(nums[i]);
            }else{
                int idx = binarySearch(res, nums[i]);
                res.set(idx, nums[i]);
            }
        }
        return res.size();
    }
    public int binarySearch(ArrayList<Integer> res, int target){
        int l = 0;
        int r = res.size()-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(res.get(mid) == target){
                return mid;
            }else if(res.get(mid) > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
    
}
/* class Solution {
    int n;
    int [][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[2501][2501];
        for(int i=0; i<dp.length-1; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, 0, -1);
    }
    public int solve(int [] nums, int i, int p){
        if(i>=n){
            return 0;
        }
        if(p != -1 && dp[i][p] != -1){
            return dp[i][p];
        }
        // take call
        int take = 0;
        if(p == -1 || nums[i]>nums[p]){
            take = 1 + solve(nums, i+1, i);
        }
        int skip = solve(nums, i+1, p);
        if(p != -1){
            dp[i][p] = Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
} */
