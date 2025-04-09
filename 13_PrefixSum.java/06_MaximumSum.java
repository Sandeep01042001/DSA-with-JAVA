import java.util.*;
import java.lang.*;
import java.io.*;
/*
Example 1
Input
5
2 1 3 5 4
2
0 1
1 2
Output
17
Example 2
Input
4
2 3 5 4
2
0 1
1 3
Output
19
*/
class Main {
    
    static final int mod = 1000000007;
    public static int maximumSum(int[] A, int[][] ops) {
       int n = A.length;
       int [] freq = new int [n];
       // step 1 -> Bulid freq array using prifix techniques
       for(int [] op : ops){
         int l = op[0];
         int r = op[1];
         freq[l]++;
         if(r+1 < n){
           freq[r+1]--;
         }
       }
       // step 2 -> Compute actual array frequence using prifix
       for(int i=1; i<n; i++){
          freq[i] += freq[i-1];
       }
       // step 3 -> sort freq ans array A
       Arrays.sort(A);
       Arrays.sort(freq);

       // step 4 -> Multiple highest freq with largest number
       int result = 0;
       for(int i=n-1; i>=0; i--){
           result = (result + (1 * A[i] * freq[i])%mod)%mod;
       }
       return result;

    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



