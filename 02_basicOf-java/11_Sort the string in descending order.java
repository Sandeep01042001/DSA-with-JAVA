import java.io.*;
import java.util.*;
 
class Solution
{
    static String solve(String S){
       // Write your code here
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        StringBuilder result = new StringBuilder(new String(charArray));
        return result.reverse().toString();
    
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String S = br.readLine();
 
         String out = Solution.solve(S);
         System.out.println(out);
 
         wr.close();
         br.close();
    }
}
