class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // step 1 -> sort meetings for start time 
        Arrays.sort(meetings, (a,b) -> a[0]- b[0]);

        // Tracks how many times each room is used
        int [] usedRoom = new int [n];
        
        // craete min heap for aviable room treck
        PriorityQueue<Integer> availableRoom = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            availableRoom.add(i);
        }

        // create min heap for tack the meeting end time sorting 
        PriorityQueue<int[]> roomUsed = new PriorityQueue<>((a,b) -> (a[1] == b[1])? a[0]-b[0] : a[1] - b[1]);

        for(int [] meeting : meetings){
            int st = meeting[0];
            int dur = meeting[1] - meeting[0];

            while(!roomUsed.isEmpty() && roomUsed.peek()[1] <= st){
                availableRoom.add(roomUsed.poll()[0]);
            }

            if(!availableRoom.isEmpty()){
                int room = availableRoom.poll();
                roomUsed.add(new int[]{room, st+dur});
                usedRoom[room]++;
            }else{
                int [] orignalM = roomUsed.poll();
                int room = orignalM[0];
                int end =  orignalM[1] + dur;
                roomUsed.add(new int[]{room, end});
                usedRoom[room]++;
            }
        }

        // Find the room with the maximum usage
        int resultRoom = 0;
        for (int i = 1; i < n; i++) {
            if (usedRoom[i] > usedRoom[resultRoom]) {
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}
