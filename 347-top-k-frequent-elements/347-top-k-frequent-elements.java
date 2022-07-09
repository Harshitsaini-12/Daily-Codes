class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer>hm=new HashMap<>();
        
      for(int i=0;i<nums.length;i++){
          hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
      }
        
      PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
         return hm.get(a)-hm.get(b);
      });
        
     for(Integer key:hm.keySet()){
         pq.add(key);
         
         if(pq.size()>k){
             pq.poll();
         }
     }
        
        int[]ans=new int[k];
        int i=0;
        
        while(pq.size()!=0){
            ans[i]=pq.poll();
            i++;
        }
        
        return ans;
        
    }
}