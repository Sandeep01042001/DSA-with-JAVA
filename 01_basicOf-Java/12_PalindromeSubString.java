import java.util.*;

public class Main {
    static boolean isPalindromic(String str){
       int left = 0;
       int rigth = str.length()-1;
       while(left<rigth){
          if(str.charAt(left) != str.charAt(rigth)){
            return false;
          }
          left++;
          rigth--;
       }
       return true;
    }
    static void palindromeSubStrs(String s) {
        //Write your code here
        HashSet<String> group = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
              String newString = (s.substring(i, j+1));
              if(isPalindromic(newString)){
                 group.add(newString);
              }
            }
        }
          List<String> sortedList = new ArrayList<>(group);
           Collections.sort(sortedList);
           for (String str : sortedList) {
              System.out.println(str);
           }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        palindromeSubStrs(s);
    }
}
