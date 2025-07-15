class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        int n = routes.length;

        if(source == target){
            return 0;
        }
        
        HashMap<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for(int i=0; i<n; i++){
            int [] stops = routes[i];
            for(int stop : stops){
                if(!stopToBuses.containsKey(stop)){
                    stopToBuses.put(stop, new ArrayList<>());
                }
                stopToBuses.get(stop).add(i);
            }
        }

        if(!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)){
            return -1;
        }

        LinkedList<Integer> qu = new LinkedList<>();
        HashSet<Integer> busesTaken = new HashSet<>();
        HashSet<Integer> stopVisited = new HashSet<>();
        qu.addLast(source);
        int res = 0;
        while(!qu.isEmpty()){
            res = res + 1;
            int size = qu.size();
            while(size-- > 0){
                int currStop = qu.removeFirst();
                List<Integer> rem = stopToBuses.getOrDefault(currStop, new ArrayList<>());
                for(int busId : rem){
                    if(busesTaken.contains(busId)){
                        continue;
                    }
                    busesTaken.add(busId);
                    for(int nextStop : routes[busId]){
                        if(stopVisited.contains(nextStop)){
                            continue;
                        }
                        if(nextStop == target){
                            return res;
                        }
                        qu.addLast(nextStop);
                        stopVisited.add(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}
