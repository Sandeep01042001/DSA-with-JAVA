import java.util.Scanner;
/* https://course.acciojob.com/idle?question=9123c554-21a6-4a1a-a824-e7fd6e851d65 */
public class Main {
    static int countX(String str, int i, int n) {
         if (i == n) {
            return 0;
        }
        int count = (str.charAt(i) == 'x') ? 1 : 0;
        return count + countX(str, i + 1,n);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n=str.length();
        System.out.println(countX(str,0,n));
    }
}
