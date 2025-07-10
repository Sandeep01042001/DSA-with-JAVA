class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int [] nsl = nextSmallerLeft(arr);
        int [] nsr = nextSmallerRight(arr);

        int mod = 1_000_000_007;
        long ans = 0;

        for(int i=0; i<n; i++){
            int left = i - nsl[i];
            int right = nsr[i] - i;
            long mul = (long)left * right;
            ans = (ans + mul * arr[i])%mod;
        }
        return (int)ans;
    }
    public int [] nextSmallerLeft(int [] arr){
        int [] ans = new int [arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
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
    public int [] nextSmallerRight(int [] arr){
        int [] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = arr.length - 1; i>=0; i--){
            while(!st.isEmpty()  && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = arr.length;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
