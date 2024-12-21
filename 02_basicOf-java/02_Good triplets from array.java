import java.util.*;
/* https://course.acciojob.com/idle?question=6f4e8e7c-f7d4-4355-ba00-63aa4608c77d 
Your task is to find the number of good triplets in the given array arr.
A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Input:
6
3 0 1 1 9 7
7 2 3
Output
4*/
class Accio {
    public int getGoodTriplets(int[] arr, int n, int a, int b, int c) {
        int count = 0;
        //int n = arr.length;

        // Iterate over all triplets (i, j, k)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}

public class Main {
    public static void main(    String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        Accio Obj = new Accio();
        System.out.println(Obj.getGoodTriplets(arr, n, a, b, c));
    }
}
