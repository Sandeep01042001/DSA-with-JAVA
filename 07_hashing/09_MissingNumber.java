import java.util.*;  /* https://course.acciojob.com/idle?question=560ab8d1-ed6f-45e0-b3be-a0d1c1d56499 */

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here
        HashMap<Integer, Integer> arr1Map = new HashMap<>();
        HashMap<Integer, Integer> arr2Map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(arr1Map.containsKey(arr[i])){
                int freq = arr1Map.get(arr[i]);
                arr1Map.put(arr[i], freq+1);
            }else{
                 arr1Map.put(arr[i], 1);
            }
           /*arr1Map.put(arr[i], map.getOrDefault(arr[i],0)+1);*/
        }
        for(int i=0; i<brr.length; i++){
            if(arr2Map.containsKey(brr[i])){
                int freq = arr2Map.get(brr[i]);
                arr2Map.put(brr[i], freq+1);
            }else{
                arr2Map.put(brr[i], 1);
            }
            
        }
        ArrayList<Integer> MissNumber = new ArrayList<>();

        for(int key : arr2Map.keySet()){
            if(arr1Map.containsKey(key)){
                int freq1 = arr1Map.get(key);
                int freq2 = arr2Map.get(key);
                if(freq1 != freq2){
                  MissNumber.add(key);
                }
            }else{
                MissNumber.add(key);
            }
        }
        Collections.sort(MissNumber);
        if(MissNumber.size() > 0){
            for(int i=0; i<MissNumber.size(); i++){
            System.out.print(MissNumber.get(i)+" ");
            }
        }else{
            System.out.print(-1);
        }
        

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}
