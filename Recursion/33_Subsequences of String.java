import java.io.*;
import java.util.*;
 /* https://course.acciojob.com/idle?question=93a39439-a127-4221-b4c4-85c7c22263e7 */
class Solution
{
    static String[] solve(String STR){
        List<String> subsequences = new ArrayList<>();
        generateSubsequences(STR, 0, "", subsequences);
        Collections.sort(subsequences);
        return subsequences.toArray(new String[0]);
    }

    private static void generateSubsequences(String str, int index, String current, List<String> subsequences) {
        if (index == str.length()) {
            if (!current.isEmpty()) {
                subsequences.add(current);
            }
            return;
        }

        // Include the current character
        generateSubsequences(str, index + 1, current + str.charAt(index), subsequences);

        // Exclude the current character
        generateSubsequences(str, index + 1, current, subsequences);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String STR = br.readLine();
 
         String[] out_ = Solution.solve(STR);
         for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(out_[i_out_]+" ");
         }
 
         wr.close();
         br.close();
    }
    
}
