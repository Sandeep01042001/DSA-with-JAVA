/*https://leetcode.com/problems/longest-subsequence-repeated-k-times/description*/
class Solution {
    String result = "";
    public String longestSubsequenceRepeatedK(String s, int k) {
            // DFS approch to solve this question
            dfs("", s, k);
            return result;
    }
    public void dfs(String curr , String s, int k){
        for(char ch = 'a'; ch<='z'; ch++){
            String newString = curr + ch;
            if(isValidLSRK(newString, s, k)){
                if(newString.length()>result.length() || 
                (newString.length() == result.length() && newString.compareTo(result) > 0)){
                    result = newString;
                }
                dfs(newString, s, k);
            }
        }
    }
    public boolean isValidLSRK(String curr , String s, int k){
            int count = 0;
            int i = 0;

            for(char ch : s.toCharArray()){
                if(ch == curr.charAt(i)){
                    i++;
                    if(i == curr.length()){
                        count++;
                        i=0;
                        if(count == k){
                            return true;
                        }
                    }
                }
            }
            return false;
        }


        // this aaproch in BFS to solve
        /*public String longestSubsequenceRepeatedK(String s, int k) {
            String result = "";
            LinkedList<String> queue = new LinkedList<>();
            queue.addLast("");

            while(!queue.isEmpty()){
                String curr = queue.removeFirst();

                for(char ch = 'a'; ch<= 'z'; ch++){
                    String next = curr + ch;
                    if(isValid(next, s, k)){
                        result = next;
                        queue.addLast(next);
                    }
                }
            }
            return result;
        }
        public boolean isValid(String curr , String s, int k){
            int count = 0;
            int i = 0;

            for(char ch : s.toCharArray()){
                if(ch == curr.charAt(i)){
                    i++;
                    if(i == curr.length()){
                        count++;
                        i=0;
                        if(count == k){
                            return true;
                        }
                    }
                }
            }
            return false;
        }*/
}
