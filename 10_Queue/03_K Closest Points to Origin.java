class Solution {  /*https://leetcode.com/problems/k-closest-points-to-origin/*/
    class Pair implements Comparable<Pair> {
        double val;
        int[] arr;

        Pair(double val, int[] arr) {
            this.val = val;
            this.arr = arr;
        }

        public int compareTo(Pair o) {
            return Double.compare(this.val, o.val);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for(int i = 0; i<points.length; i++){
            int [] point = points[i];
            int x = point[0];
            int y = point[1];
            double sqrt = x * x + y * y;
            q.add(new Pair(sqrt, point));
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair rem = q.poll();
            ans[i] = rem.arr;
        }

        return ans;
    }
}
