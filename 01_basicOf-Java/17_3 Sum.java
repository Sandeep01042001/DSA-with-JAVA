/* https://leetcode.com/problems/search-in-rotated-sorted-array/ */
class Solution {
    public int search(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        // Find the index of the smallest element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int rotationIndex = lo;

        // Decide which part of the array to search in
        lo = 0;
        hi = arr.length - 1;
        if (target >= arr[rotationIndex] && target <= arr[hi]) {
            lo = rotationIndex;
        } else {
            hi = rotationIndex - 1;
        }

        // Perform binary search in the determined range
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
