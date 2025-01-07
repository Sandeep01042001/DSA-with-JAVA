/* https://course.acciojob.com/idle?question=f7a7790c-2f0f-49ef-aadb-ee0031f88e28 */
import java.util.*;
class Main{
	public static void main(String[] args){
		try (Scanner sc = new Scanner(System.in)) {
        int n=sc.nextInt();
        int target=sc.nextInt();
        int []A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        Solution ob =new Solution();
        int []ans = ob.twosum(A,n,target);
        System.out.println(ans[0]+" "+ans[1]);                        
		}
	}

}

class Solution{
 
    public int[] twosum(int A[], int n, int target){
        //Write code here
        int left = 0, right = A.length - 1;
        while (left < right) {
            int sum = A[left] + A[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
