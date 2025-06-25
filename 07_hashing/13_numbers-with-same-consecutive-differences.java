/*https://leetcode.com/problems/numbers-with-same-consecutive-differences/*/
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(n==1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        for(int i=1; i<=9; i++){
            solve(n, k, i, 0, i, list);
        }
        int size = list.size();
        int [] ans = new int[size];
        for(int i=0; i<size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void solve(int n, int k, int curr, int len, int prev, ArrayList<Integer> list){
        if(len == n-1){
            list.add(curr);
            return;
        }
        int next = prev + k;
        if(next < 10){
            solve(n, k, (curr * 10) + next, len+1, next, list);
        }
        next = prev - k;
        if(k != 0 && next >= 0){
            solve(n, k, (curr * 10) + next, len+1, next, list);
        }
    }
}
