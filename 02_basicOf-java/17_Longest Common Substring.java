import java.util.*;
/* https://course.acciojob.com/idle?question=0a6384a6-8341-4f70-a6be-58b9cd3f8b96 */
class Main {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        
        int p=sc.nextInt();             // Take size of both the strings as input
        int q=sc.nextInt();
        
        String a=sc.next();            // Take both the string as input
        String b=sc.next();
        
        Solution obj = new Solution();
        
        System.out.println(obj.lcs(p, q, a, b));

        sc.close();
    
    }
}


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String a, String b)
    {
       int[][] dp = new int[x + 1][y + 1];

        int maxLength = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }
    
}
