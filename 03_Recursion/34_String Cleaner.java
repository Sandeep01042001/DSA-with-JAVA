import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=e44c691c-d898-4fe4-8b1f-7de20c826a8d */
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
    
        String str=sc.nextLine();
        Solution accio=new Solution();
        String ans=accio.findString(str);

        System.out.println(ans);
    }
}


class Solution {

    public String findString(String str)
    {
        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            return findString(str.substring(1));
        }
        return str.charAt(0) + findString(str.substring(1));
    }
}
