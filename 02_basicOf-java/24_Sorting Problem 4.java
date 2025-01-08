import java.util.*;
/* https://course.acciojob.com/idle?question=73f513cd-79cf-427c-9d21-895b7bf1b53a */
class Solution {
    public int findMajorityElement(int[] nums) {
        int n = nums.length;

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the elements
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        // The majority element will be at n/2 index after sorting
        return nums[n / 2];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution Obj = new Solution();
        int result = Obj.findMajorityElement(nums);
        System.out.println(result);
        sc.close();
    }
}
