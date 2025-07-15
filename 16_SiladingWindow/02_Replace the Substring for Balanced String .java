/*Example 1:
Input: s = "QWER"
Output: 0
Explanation: s is already balanced.
Example 2:
Input: s = "QQWE"
Output: 1
Explanation: We need to replace a 'Q' to 'R', so that "RQWE" (or "QRWE") is balanced.
https://leetcode.com/problems/replace-the-substring-for-balanced-string/description/*/
class Solution {
    public int balancedString(String s) {
        int [] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch - 'A']++;
        }
        
        int result = s.length();
        int target = s.length()/4;
        int i=0; 
        int j = 0;
        while(j<s.length()){
            arr[s.charAt(j)-'A']--;
            while(i<s.length() && arr['Q'-'A'] <= target && arr['W'-'A'] <= target 
                  && arr['E'-'A'] <= target && arr['R'-'A'] <= target){
                 arr[s.charAt(i)-'A']++;
                 result = Math.min(result , j-i+1);
                 i++;
            }
            j++;
        }

        return result;
    }
}
