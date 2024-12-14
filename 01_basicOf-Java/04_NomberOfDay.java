import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        //Write your code here
        Scanner scr = new Scanner(System.in);
        
        int num = scr.nextInt();
        int days;
        switch (num){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            days = 31;
            break;
            case 4 : case 6: case 9: case 11:
            days = 30;
            break;
            case 2:
            days = 28;
            break;
            default :
             System.out.println("pleace enter month(1-12)");
             System.out.println("Invalid month number.");
                return;

        }
        
        System.out.println(days);
    }
}
