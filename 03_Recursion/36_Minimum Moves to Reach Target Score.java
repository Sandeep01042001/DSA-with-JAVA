class Solution { /*https://leetcode.com/problems/minimum-moves-to-reach-target-score/submissions/1683613675/*/
    public int minMoves(int target, int maxDoubles) {
        return solve(target, maxDoubles, 0);
    }
    public int solve(int target, int maxDoubles, int ans){
        if(target == 1){
            return ans;
        }
        if(maxDoubles == 0){
            return ans + target - 1;
        }

        if(target % 2 == 0 && maxDoubles > 0){
            return solve(target/2, maxDoubles - 1, ans + 1);
        }else{
            return solve(target - 1, maxDoubles, ans + 1);
        }
    }
} 
