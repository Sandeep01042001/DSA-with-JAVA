/*Example 3:
Input: nums = [3,1,5,6,4,2]
Output: 60
Explanation: The maximum min-product is achieved with the subarray [5,6,4] (minimum value is 4).
4 * (5+6+4) = 4 * 15 = 60.*/
/*https://leetcode.com/problems/maximum-subarray-min-product/description/*/
class Solution {  
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] pSum = new long[n + 1]; // create pSum of nums Array length + 1

        for(int i=0; i<n; i++){ // fill pSum array 
            pSum[i+1] = pSum[i]+nums[i];
        }

        int []nsl = nextSmallerLeft(nums);
        int []nsr = nextSmallerRight(nums);

        long res = 0;
        for (int i = 0; i < n; i++) {
            int left = nsl[i];
            int right = nsr[i];

            long sum = pSum[right] - pSum[left + 1];
            res = Math.max(res, sum * nums[i]);
        }

        return (int) (res % 1_000_000_007);

    }
    public int [] nextSmallerLeft(int [] nums){
        int [] ans = new int [nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[i] <= nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int [] nextSmallerRight(int [] nums){
       int [] ans = new int [nums.length];
       Stack<Integer> st = new Stack<>();
       for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[i] < nums[st.peek()]){
               st.pop();
            }
            if(st.isEmpty()){
                ans[i] = nums.length;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
       }
       return ans;
    }
}
