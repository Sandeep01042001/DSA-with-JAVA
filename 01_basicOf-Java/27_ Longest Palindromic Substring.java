/*Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0){
            return "";
        }
        int n = s.length();
        int stIdx = -1;
        int enIdx = -1;

        for(int i=0; i<n; i++){
            int odd = checkPalimdrome(i, i, s);
            int even = checkPalimdrome(i, i+1, s);
            int maxLen = Math.max(odd, even);
            if(maxLen > enIdx - stIdx){
                stIdx = i - (maxLen - 1)/2;
                enIdx = i + maxLen/2;
            }
        }

        return s.substring(stIdx, enIdx+1);

    }
    public int checkPalimdrome(int i, int j, String s){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j - i  -1;

    }
}
