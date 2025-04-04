class Solution {
    public int pivotIndex(int[] nums) {
        int [] pSum = new int [nums.length];
        int [] sSum = new int [nums.length];
        pSum[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            pSum[i] = pSum[i-1]+nums[i];
        }
        sSum[nums.length-1] = nums[nums.length-1];
        for(int j=nums.length-2; j>=0; j--){
           sSum[j] = sSum[j+1]+nums[j];
        }
        int idx = -1;
        int i=0;
        int j=0;
        while(i<pSum.length && j<sSum.length){
            if(pSum[i] == sSum[j]){
                idx = i;
                break;
            }else{
                i++;
                j++;
            }
        }
        return idx;
    }
}
