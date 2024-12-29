import java.util.*;

class Solution {
    public List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        //write your code here 
        result = new ArrayList<>();
        ArrayList<Integer> helper = new ArrayList<>();
        findCombination(k, n, 1, helper, result);
        return result;

    }
    public void findCombination(int k, int target, int start,ArrayList<Integer> helper,List<List<Integer>> result){
         if(k==helper.size()&& target == 0){
            result.add(new ArrayList<Integer>(helper));
            return;
         }
        for(int i=start; i<=9; i++){
            if(i>target){
                break;
            }
            helper.add(i);
            findCombination(k, target-i, i+1, helper, result);
            helper.remove(helper.size()-1);
        }
    }
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        
        Solution ob = new Solution();
        List<List<Integer>> ans = ob.combinationSum3(k,n);
        for(int i = 0 ; i < ans.size() ; ++i){
            Collections.sort(ans.get(i));
        }
        Collections.sort(ans, (o1, o2) -> {
                int m = Math.min(o1.size(), o2.size());
                for (int i = 0; i < m; i++) {
                    if (o1.get(i) == o2.get(i)){
                        continue;
                    }else{
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 1;
            });
        for (int i = 0; i < ans.size (); i++)
            {
                for (int j = 0; j < ans.get(i).size (); j++)
                {
                    System.out.print(ans.get(i).get(j)+" ");
                }
                System.out.println();

            }


    }
}