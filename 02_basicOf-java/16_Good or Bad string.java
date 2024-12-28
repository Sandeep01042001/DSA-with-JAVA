/* If there are more than 3 consonants together or more than 5 vowels together,
the String is considered to be "BAD". A String is considered "GOOD" only if it is not “BAD”. */

import java.io.*;
import java.util.*;        /* https://course.acciojob.com/idle?question=9d7e715e-eacd-4434-b572-57df7e6623ba */
public class Main {
    
    public static void solve(String s){
    	int maxConsonants = 3;
        int maxVowels = 5;

        int consonantCount = 0;
        int vowelCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                vowelCount++;
                consonantCount = 0;
            } else if (ch == '?') {
                vowelCount++;
                consonantCount++;
            } else {
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount > maxVowels || consonantCount > maxConsonants) {
                System.out.println(0);
                return; // BAD string
            }
        }

        System.out.println(1); // GOOD string
    }
    public static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        solve(s);
        
    }
}
