import java.util.*;
/* https://course.acciojob.com/idle?question=1f8e91a5-e54f-488c-8706-aaf17b2ceb3d */
public class Main {
    public static int findIndex(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo + hi)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid]<key){
                lo = mid + 1;
            } else{
                hi = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, key;
        n = sc.nextInt();
        key = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(findIndex(key, arr));
        sc.close();
    }
}