import java.util.*;  
/* https://course.acciojob.com/idle?question=e92bcdab-2a48-4c81-9739-9f5fd65ba961 */
class Solution{
    public void printSubstrings(String s){
         for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                System.out.println(s.substring(i, j));
            }
        }
    }
}

public class Main   
{
public static void main(String args[])  
{  
	Scanner sc= new Scanner(System.in);
	
	String str = sc.next();
    Solution obj = new Solution();
    obj.printSubstrings(str);
    }  
}  
