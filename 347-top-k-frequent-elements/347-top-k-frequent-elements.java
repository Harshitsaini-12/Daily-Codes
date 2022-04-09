class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        int[]ans=new int[k];
        
        for(int val:nums){
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->hm.get(a)-hm.get(b));
        
        for(Integer key:hm.keySet()){
            pq.add(key);
            
            if(pq.size()>k)pq.poll();
        }
        int i=0;
        while(pq.size()!=0){
            ans[i]=pq.poll();
            i++;
        }
        
        return ans;
    }
}