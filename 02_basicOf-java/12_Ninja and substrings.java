import java.util.*;
/* https://course.acciojob.com/idle?question=b5693922-89e5-4bbf-a2ec-db099969c8e2 */
public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            String str = sc.next();
            int ans = Solution.ninjaAndSubstrings(str);
            System.out.println(ans);
        }
    }
}
class Solution {
	static int ninjaAndSubstrings(String str) {
		 Set<String> substrings = new HashSet<>();
        for (int i = 0; i < str.length() - 1; i++) {
            substrings.add(str.substring(i, i + 2));
        }
        return substrings.size();
	}
}
