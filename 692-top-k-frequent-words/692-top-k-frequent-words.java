class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>hm=new HashMap<>();
        
        for(String s:words)hm.put(s,hm.getOrDefault(s,0)+1);
        
        PriorityQueue<String>pq=new PriorityQueue<>((a,b)->{
           if(hm.get(a)==hm.get(b)) {
               return b.compareTo(a);
           }
            return hm.get(a)-hm.get(b);
        });
        
        for(String key:hm.keySet()){
            pq.add(key);
            
            if(pq.size()>k)pq.remove();
        }
        
        List<String>ans=new LinkedList<>();
        
        while(pq.size()!=0){
            ans.add(0,pq.remove());
        }
        
        return ans;
    }
}