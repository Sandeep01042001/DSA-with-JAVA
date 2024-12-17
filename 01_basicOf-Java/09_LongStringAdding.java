import java.util.*;

class Solution {
    public static String addString(String number1, String number2)
    {
        //Write your code here
        StringBuilder result = new StringBuilder();
        int i = number1.length()-1;
        int j = number2.length()-1;
        int ceary =0;
        while(i>=0 || j>= 0 || ceary > 0){
            int digit1= (i>=0) ? number1.charAt(i) - '0':0;
            int digit2= (j>=0) ? number2.charAt(j) - '0':0;
            int sum = digit1 + digit2 + ceary;
            ceary = sum/10;
            result.append(sum%10);
            i--;
            j--;
        }
        return result.reverse().toString();
       
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number1 = sc.nextLine();
        String number2 = sc.nextLine();
        Solution Obj = new Solution();
        System.out.println(Obj.addString(number1,number2));
    }
}
