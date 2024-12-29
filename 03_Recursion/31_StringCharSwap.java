import java.io.*;
import java.util.*;
/*Example Input Input 1:    https://course.acciojob.com/idle?question=82d3585b-2bde-475e-8a77-12d0a6c04ed9
A = "254" B = 1
Output 1:
524
Input 2:
A = "254" B = 2
Output :
542*/
public class Main {
	public static void main(String args[]) {
		// your code here
		Scanner scanner = new Scanner(System.in);
		String A = scanner.next();
        int B = scanner.nextInt();
        String result = findMaxString(A, B);
        System.out.println(result);
	}
	public static String findMaxString(String A, int B){
		 char[] arr = A.toCharArray();
        StringBuilder max = new StringBuilder(A);
        findMaxHelper(arr, B, max);
        return max.toString();
	}
	public static void findMaxHelper(char [] arr, int B, StringBuilder max){
		 if (B == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    swap(arr, i, j);
                    String current = new String(arr);
                    if (current.compareTo(max.toString()) > 0) {
                        max.replace(0, max.length(), current);
                    }
                    findMaxHelper(arr, B - 1, max);
                    swap(arr, i, j);
                }
            }
        }
	}
	public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
