import java.util.*;  /*https://leetcode.com/problems/asteroid-collision/description/*/

public class Main {

    public static int [] asteroidCollision(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.size()==0 || arr[i]>0){
                stack.push(arr[i]);
            }else{
                while(stack.size()>0){
                    int top = stack.peek();
                    if(top<0){
                        stack.push(arr[i]);
                        break;
                    }
                    int val = Math.abs(arr[i]);
                    if(top == val){
                        stack.pop();
                        break;
                    }else if(val<top){
                        break;
                    }else{
                       stack.pop();
                       if(stack.size()==0){
                          stack.push(arr[i]);
                          break;
                       }
                    }
                }
            }

        }
        int ans[] = new int [stack.size()];
        for(int i=stack.size()-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        
        return ans;

           
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scanner.nextInt();
        }

        int [] ans = asteroidCollision(asteroids); 

        if(ans.length==0){
             System.out.print(-1);
        }else{
              for (int asteroid : ans) {
                 System.out.print(asteroid + " ");
              }
        }
    }
}
