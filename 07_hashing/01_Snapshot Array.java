import java.util.*;
/* https://course.acciojob.com/idle?question=5f0966c6-068f-4ff3-b532-621cfaa4d90c */
public class Main
{
    public static List<TreeMap<Integer, Integer>> array;
    public static int snapId;
    public static void SnapshotArray(int length) {
        array = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            array.add(new TreeMap<>());
            array.get(i).put(0, 0); // Initialize with snap_id = 0 and value = 0
        }
        snapId = 0;
    }

    public static void set(int index, int val) {
         array.get(index).put(snapId, val);
    }

    public static int snap() {
       return snapId++;
    }

    public static int get(int index, int snapId) {
        return array.get(index).floorEntry(snapId).getValue();
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String temp;
		int param1, param2;
		param1 = input.nextInt();
        SnapshotArray(param1);
        String[] arr = new String[n];
		for (int i = 0; i < n; i++){

            temp = input.next();
		    if(temp.equals("set") || temp.equals("get"))
            {
              param1 = input.nextInt();
              param2 = input.nextInt();
              if(temp.equals("set"))
              {
                  set(param1, param2);
              }
              else{
                  System.out.println(get(param1, param2));
              }
            }
            else{
                System.out.println(snap());
            }
		}
        
	}
}
