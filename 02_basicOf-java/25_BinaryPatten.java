import java.util.*;
/* https://course.acciojob.com/idle?question=ee237a54-3d05-4ca7-a888-d119da5e1d3a */
class Solution {
    static void print(int n) {
         for (int i = n; i > 0; i--) {
            // Decide the character to print based on the line number
            char toPrint = (i % 2 == 0) ? '0' : '1';

            // Print the character 'i' times
            for (int j = 0; j < i; j++) {
                System.out.print(toPrint);
            }

            // Move to the next line
            System.out.println();
        } 
    }
}
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution.print(n);
    }
}
