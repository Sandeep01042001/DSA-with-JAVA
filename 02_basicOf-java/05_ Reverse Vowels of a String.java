import java.util.*;
/* https://leetcode.com/problems/reverse-vowels-of-a-string/submissions/1485567901/ */
class Solution {
    public static String reverseVowels(String s) {
        // Convert the string to a character array for easy swapping
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        // Define a set of vowels for quick lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        // Use two-pointer approach to find and swap vowels
        while (left < right) {
            // Move the left pointer until a vowel is found
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Move the right pointer until a vowel is found
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        // Convert the character array back to a string and return it
        return new String(chars);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the string
        System.out.println("Enter the string:");
        String s = sc.nextLine();

        // Reverse vowels in the string
        Solution obj = new Solution();
        String result = obj.reverseVowels(s);

        // Output the result
        System.out.println("Resulting string:");
        System.out.println(result);

        sc.close();
    }
}
