/*https://leetcode.com/problems/search-in-rotated-sorted-array/description/*/
/*Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivetIdx = findPivet(nums, n);
        int idx = binarySearch(0, pivetIdx-1, nums, target);
        if(idx == -1){
            idx = binarySearch(pivetIdx, n-1, nums, target);
        }
        return idx;
    }
    public int binarySearch(int lo, int hi, int []nums, int target){
        int idx = -1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid]==target){
               idx = mid;
               break;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }

        }
        return idx;
    }
    public int findPivet(int [] nums, int n){
        int lo = 0;
        int hi = n-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]>nums[hi]){
                lo = mid +1;
            }else{
                hi = mid;
            }
        }
        return hi;
    }
}
