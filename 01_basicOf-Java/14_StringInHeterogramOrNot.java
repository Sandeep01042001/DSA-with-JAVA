import java.util.*;
import java.util.HashSet;

public class Main {

    public static boolean isHeterogram(String S) {
        HashSet<Character> seen = new HashSet<>();

        for (char ch : S.toCharArray()) {
            if (seen.contains(ch)) {
                return false;
            }
            seen.add(ch);
        }

        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Read input
        String S = scanner.nextLine();

        // Check if the string is a heterogram
        if (isHeterogram(S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        scanner.close();
    }
}
