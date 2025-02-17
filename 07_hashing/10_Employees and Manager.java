import java.io.*;
import java.util.*;  /*https://course.acciojob.com/idle?question=7d2ada34-6296-40ca-8bbf-389f729ac8c5*/

class Solution {

    public void EmpUnderManager(Map<String, String> emp)
	{
		HashMap<String, List<String>> tree = new HashMap<>();
        HashSet<String> allPeople = new HashSet<>();
        for(Map.Entry<String, String> entry : emp.entrySet()){
            String employee = entry.getKey();
            String manager = entry.getValue();
            allPeople.add(employee);
            allPeople.add(manager);
            if(!employee.equals(manager)){
                tree.putIfAbsent(manager, new ArrayList<>());
                tree.get(manager).add(employee);
            }
        }
        //System.out.println(allPeople);
        //System.out.print(tree);
        HashMap<String, Integer> result = new HashMap<>();
        for(String person : allPeople){
            if(!result.containsKey(person)){
                dfs(person, tree, result);
            }
        }
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
	}
    public int dfs(String manager,HashMap<String, List<String>> tree ,HashMap<String, Integer> result ){
        if(!tree.containsKey(manager)){
            result.put(manager, 0);
            return 0;
        }
        int count = 0;
        for(String emp : tree.get(manager)){
            count += 1 + dfs(emp, tree, result);
        }
        result.put(manager, count);
        return count;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}
