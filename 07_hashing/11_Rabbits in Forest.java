class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ans : answers){
            map.put(ans, map.getOrDefault(ans, 0)+1);
        }
        int totalRabbits = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int rSize = entry.getKey() + 1;
            int count = entry.getValue();
            int groupSize = (int)Math.ceil((double)count / (rSize));
            totalRabbits += groupSize * rSize;
        }
        return totalRabbits;
    }
}
