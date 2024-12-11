import java.util.*;

public class Main {
    public static int multiplyRecursively(int n, int m) {
        if (m == 0) {
            return 0;
        }
        return n + multiplyRecursively(n, m - 1);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int result = multiplyRecursively(n, m);
        System.out.println(result);
    }
}
