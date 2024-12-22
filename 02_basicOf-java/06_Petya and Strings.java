import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=4904e264-a289-414c-a4da-aa5ca68bc20d */
public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Read the input strings
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // Convert both strings to lowercase to ignore case sensitivity
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Compare the strings lexicographically
        int comparisonResult = str1.compareTo(str2);

        // Output the result
        if (comparisonResult < 0) {
            System.out.println("-1");
        } else if (comparisonResult > 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        scanner.close();
    }
}
