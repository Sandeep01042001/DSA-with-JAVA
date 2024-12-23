import java.io.*;
import java.util.*;
/* https://course.acciojob.com/idle?question=6dc8bb42-64d1-4114-bcc4-f138ed5373c3 */
public class Main {

    static ArrayList<Integer> arrayGenerator(String s){ 
        ArrayList<Integer> result = new ArrayList<>();
        String[] parts = s.split(","); // Split the string by commas
        for (String part : parts) {
            result.add(Integer.parseInt(part.trim())); // Convert each part to an integer and add to the list
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        while (t-- > 0) {
            String s = input.nextLine();
            ArrayList<Integer> ans = arrayGenerator(s);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if (i != ans.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
    }
}
