import java.util.*;

class Main {
	public static void main(String args[]) {
		// your code here
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
        for(int i=0; i<=num; i++){
			if(i%2 == 0){
				System.out.print(i + " ");
			}
		}
	}
}
