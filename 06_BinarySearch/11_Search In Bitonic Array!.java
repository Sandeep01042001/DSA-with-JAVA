/* https://course.acciojob.com/idle?question=43a06a39-622a-4331-9a4c-62ebfe7bc7ae */
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        int N = sc.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        arr[i]=sc.nextInt();
        
        int target=sc.nextInt();

        Accio ob = new Accio();
        int ans= ob.findElement(arr, N,target);

        System.out.println(ans);
    
    }
}


class Accio {
    
    static int findElement(int arr[], int n,int target)
    {
        int peakIndex = findPeakElement(arr, n);

        // Search in the increasing part
        int index = binarySearch(arr, 0, peakIndex, target, true);
        if (index != -1) {
            return index;
        }

        // Search in the decreasing part
        return binarySearch(arr, peakIndex + 1, n - 1, target, false);

    }
    public static int findPeakElement(int[] arr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // Peak index
    }

    public static int binarySearch(int[] arr, int low, int high, int target, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (ascending) {
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
