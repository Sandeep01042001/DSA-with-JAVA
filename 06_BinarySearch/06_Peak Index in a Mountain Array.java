import java.io.*;
import java.util.*;
/* https://leetcode.com/problems/peak-index-in-a-mountain-array/
https://course.acciojob.com/idle?question=fc5f657f-bf71-49c6-890c-96a5835f684b */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int prev = mid-1 >= 0 ? arr[mid-1] : Integer.MIN_VALUE;
            int fwd = mid + 1 < arr.length ? arr[mid+1] : Integer.MIN_VALUE;
            if(prev < arr[mid] && arr[mid] < fwd){
                lo = mid + 1;
            }else if(prev > arr[mid] && arr[mid] > fwd){
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}
