import java.util.*;
import java.lang.*;
import java.io.*;
/* https://leetcode.com/problems/search-a-2d-matrix/description/ 
https://course.acciojob.com/idle?question=9c215979-6be0-4055-8a42-9d20c4b90169*/
class Main {
  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int N = sc.nextInt();
	  int[] A = new int[N];
	  for(int i=0;i<N;i++){
          A[i] = sc.nextInt();
      }
	  int B = sc.nextInt();
	  Solution ob = new Solution();
    System.out.println(ob.search(A,B));
		
	}
}

class Solution{
    public int search(final int[] arr, int target) {
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
