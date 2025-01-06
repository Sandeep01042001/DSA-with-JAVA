import java.util.*;
/* https://leetcode.com/problems/valid-anagram/description/
https://course.acciojob.com/idle?question=bedea261-bd68-4e76-aca3-3bab794e91e2 */ 
class Solution {
   static boolean areAnagram(String str1, String str2) {
       //Write your code here
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for (char c : str1.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            charCount[c - 'a']--; 
        }
         for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
