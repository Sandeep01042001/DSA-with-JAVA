import java.util.Scanner;
/* https://course.acciojob.com/idle?question=23ac85cb-f708-484d-ae82-022fc5e118a7 */
class Solution{
    public static String removeOccurrences(String s, String part) {
        // Write your code here
        StringBuilder sb = new StringBuilder(s);
        int index;
        while ((index = sb.indexOf(part)) != -1) {
            sb.delete(index, index + part.length());
        }
        return sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String part = sc.nextLine();
        String result = Solution.removeOccurrences(s, part);
        System.out.println(result);
        sc.close();
    }
}
