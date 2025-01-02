import java.util.*;
/* https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/ */
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } 
            // Left half is sorted
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}
