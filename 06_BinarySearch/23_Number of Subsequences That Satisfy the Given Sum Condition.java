class Solution { /*https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/*/
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);
        int n = nums.length;

        // Precompute powers of 2 up to n
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int res = 0;
        int l = 0, r = n - 1;

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                res = (res + power[r - l]) % mod;
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}
