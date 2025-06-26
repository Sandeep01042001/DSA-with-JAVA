/*https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/*/
class Solution {
    public int longestSubsequence(String s, int k) {
        int result = 0;
        long currentValue = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                result++;
            }else if(result < 31 && currentValue + (1L << result) <= k){
                currentValue += (1L << result);
                result++;
            }
        }
        return result;
    }
}
