import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (isPrime(N)) {
            System.out.println(N + " is a prime number");
        } else {
            System.out.println(N + " is not a prime number");
        }
        scanner.close();
    }
    
    
    public static boolean isPrime(int N) {
        if (N <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                return false; 
            }
        }
        return true;
    }
}
