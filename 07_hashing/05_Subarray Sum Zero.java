import java.util.*;
/* https://course.acciojob.com/idle?question=e3d6077b-afee-46c2-85fe-58848e357910 */
public class Main {
    static void zeroSubarray(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1))); // Handle subarray starting from index 0

        int cumulativeSum = 0;
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        // Sort results by starting index, and then by ending index
        result.sort((a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Print results
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int[] range : result) {
                System.out.println("Subarray found from Index " + range[0] + " to " + range[1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        zeroSubarray(arr);
        sc.close();
    }
}
