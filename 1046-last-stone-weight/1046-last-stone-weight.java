class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1)return stones[0];
        
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
                
        for(int val:stones){
            pq.add(val);
        }
        
        while(pq.size()>1){
            int v2=pq.poll();
            int v1=pq.poll();
            
            if(v1!=v2){
                pq.offer(v2-v1);
            }
        }
        
        return pq.isEmpty()?0:pq.poll();
    }
}