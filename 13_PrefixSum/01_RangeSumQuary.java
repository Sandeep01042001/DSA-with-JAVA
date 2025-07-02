class NumArray {
    int [] arr;
    int [] prefix;
    public NumArray(int[] nums) {
        this.arr = nums;
        this.prefix = new int [nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int leftSum = left == 0 ? 0 : prefix[left-1];
        int rightSum = prefix[right];
        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */