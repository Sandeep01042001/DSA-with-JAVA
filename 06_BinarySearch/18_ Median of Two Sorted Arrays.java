/*https://leetcode.com/problems/median-of-two-sorted-arrays/description/*/
/*Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int size = n + m;
        
        int idx1 = (size/2)-1;
        int ele1 = -1;
        int idx2 = size/2;
        int ele2 = -1;

        int i=0, j=0, k=0;

        while (i<n && j<m) {
            if(nums1[i] < nums2[j]){
                if(k == idx1){
                    ele1 = nums1[i];
                }else if(k == idx2){
                    ele2 = nums1[i];
                }
                i++;
            }else{
                if(k == idx1){
                    ele1 = nums2[j];
                }else if(k == idx2){
                    ele2 = nums2[j];
                }
                j++;
            }
            k++;
        }
        
        while(i<n){
            if(k == idx1){
                ele1 = nums1[i];
            }else if(k == idx2){
                ele2 = nums1[i];
            }
            i++;
            k++;
        }
        while(j<m){
             if(k == idx1){
                ele1 = nums2[j];
            }else if(k == idx2){
                ele2 = nums2[j];
            }
            j++;
            k++;
        }
        if (size%2==1) return ele2;
        else return (ele1 + ele2)/2.0;
    }
}
