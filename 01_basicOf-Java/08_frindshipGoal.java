import java.util.*;


public class Main {

  public static int[] solve(int[] arr) {
    // write your code here
     HashMap<Integer, Integer> result = new HashMap<>();
     int prifixSum = 0;
     int st = -1;
     int ed = -1;
     result.put(0, -1);
     for(int i=0; i<arr.length; i++){
        prifixSum += arr[i];
        if(result.containsKey(prifixSum)){
          int preIndex = result.get(prifixSum);
          if(preIndex >= st){
            st = preIndex +1;
            ed = i;
          }
        }else{
          result.put(prifixSum, i);
        }
     }
     if(st == -1 && ed == -1){
      return new int []{-1,-1};
     }
     return new int[]{st,ed};
    
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] arr = new int[scn.nextInt()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    scn.close();
    int[] ans = solve(arr) ; 
    System.out.print(ans[0] + " "+ans[1]) ; 
  }

} 
