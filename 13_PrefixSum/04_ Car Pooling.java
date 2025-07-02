class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        int currCapacity = 0;

        for(int i=0; i<trips.length; i++){
            int [] trip = trips[i];
            int currSt = trip[1];
            while(pq.size()>0 && currSt >= pq.peek()[2]){
                int [] rem = pq.poll();
                currCapacity -= rem[0];
            }
            
            if(currCapacity + trip[0] <= capacity){
                currCapacity += trip[0];
                pq.add(trip);
                
            }else{
                return false;
            }
        }
        return true;
    }
}
