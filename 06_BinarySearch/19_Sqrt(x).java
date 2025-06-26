class Solution {
    public int mySqrt(int x) {
         if (x == 0 || x == 1) {
           return x; 
        }
       int l = 0;
       int h = x;
       int ans = 0;

        while(l<=h){
            int mid = l + (h - l)/2;
            if(mid <= x/mid){
                l = mid + 1;
                ans = mid;
            }else{
                h = mid -1;
            }
        }
       return ans;
    }
}
