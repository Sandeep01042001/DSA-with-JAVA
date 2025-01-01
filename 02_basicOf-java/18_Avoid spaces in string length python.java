/* https://course.acciojob.com/idle?question=2c0664d4-dd00-4551-8490-016ca397847b */
import java.io.*;
import java.util.*;
class Solution {
    public void solve(Scanner s) {
        // write your code here
         Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
         int count = str.replace(" ", "").length();
        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        solution.solve(sc);
    }
}
