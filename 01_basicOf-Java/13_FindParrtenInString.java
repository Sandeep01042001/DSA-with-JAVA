import java.util.*;
/*Input:
xxy yxxyxxy
Output:
YES*/
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String s = sc.next();
        boolean ans = Solution.findPattern(p, s);
        if(ans) {
            System.out.print("YES\n");
        }
        else {
            System.out.print("NO\n");
        }
    }
}
class Solution {

    static boolean findPattern(String P, String S) {
        int pLength = P.length();
        int sLength = S.length();

        for (int i = 0; i <= sLength - pLength; i++) {
            int j;
            for (j = 0; j < pLength; j++) {
                if (S.charAt(i + j) != P.charAt(j)) {
                    break;
                }
            }
            if (j == pLength) {
                return true; 
            }
        }
        return false;
    }
}
