class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean>hm=new HashMap<>();
        
        for(int val:nums){
            hm.put(val,true);
        }
        
        for(int val:nums){
            if(hm.containsKey(val-1)){
                hm.put(val,false);
            }
        }
        
        
        int ml=0;
        
        for(int val:nums){
         if(hm.get(val)==true){
             int l=1;
             int tsp=val;
             
             while(hm.containsKey(tsp+l)){
                 l++;
             }
             
             if(l>ml){
                 ml=l;
             }
         }
            
        }
        
        
        return ml;
    }
}