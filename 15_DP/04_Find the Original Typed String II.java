class Solution {
    public int possibleStringCount(String word, int k) {
        if(word.length() == 0){
            return 0;
        }
        int mod = 1000000007;

        List<Integer> groups = new ArrayList<>();
        int group = 1;
        for(int i=1; i<word.length(); i++){
            if(word.charAt(i) == word.charAt(i-1)){
                group++;
            }else{
                groups.add(group);
                group = 1;
            }
        }
        groups.add(group);

        long totalWays = 1;
        for(int num : groups){
            totalWays = (totalWays * num) % mod;
        }

        if(k <= groups.size()){
            return (int)totalWays;
        }

        int [] dp = new int [k];
        dp[0] = 1;
        for(int num : groups){
            int [] newDp = new int[k];
            long sum = 0;
            for(int i=0; i<k; i++){
                if(i>0){
                    sum = (sum + dp[i-1]) % mod;
                }
                if(i > num){
                    sum = (sum - dp[i-num-1] + mod) % mod;
                }
                newDp[i] = (int)sum;
                //System.out.print(newDp[i]+ " ");
            }
            //System.out.println();
            dp = newDp;
        }
        long invalid = 0;
        for(int i = groups.size(); i<k; i++){
            invalid = (invalid + dp[i]) % mod;
        }

        return (int)((totalWays - invalid + mod)%mod);
    }
}
