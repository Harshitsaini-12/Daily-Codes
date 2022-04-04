class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        
        int pump=0;
        int range=startFuel;
        int i=0;
        
        while(range<target){
            
            //adding the pq if the fuel is in range
            while(i<stations.length){
                if(stations[i][0]<=range){
                    pq.add(stations[i][1]);
                }else{
                    break;
                }
                i++;
            }
            
            if(pq.size()==0)return -1;
            
            //adding the distance to the range .
            range+=pq.remove();
            pump++;
        }
        
        return pump;
    }
}