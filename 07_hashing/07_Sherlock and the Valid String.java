import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=a4347de7-e0fa-4a6a-8fe7-5a6b318180dd */ 
class Solution{
    public static boolean isValid(String s){
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Count the frequency of frequencies
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : frequencyMap.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        if (freqCount.size() == 1) {
            // All characters have the same frequency
            return true;
        } else if (freqCount.size() == 2) {
            // Two distinct frequencies
            Iterator<Map.Entry<Integer, Integer>> iterator = freqCount.entrySet().iterator();
            Map.Entry<Integer, Integer> entry1 = iterator.next();
            Map.Entry<Integer, Integer> entry2 = iterator.next();

            int freq1 = entry1.getKey(), count1 = entry1.getValue();
            int freq2 = entry2.getKey(), count2 = entry2.getValue();

            // Check if one frequency can be adjusted to match the other
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
                return true;
            }

            // Check if reducing one occurrence makes frequencies equal
            if ((Math.abs(freq1 - freq2) == 1) && (count1 == 1 || count2 == 1)) {
                return true;
            }
        }

        return false;
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        Solution Obj = new Solution();
        if(Obj.isValid(s)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
