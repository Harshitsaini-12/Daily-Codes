class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer,Integer>lastRain=new HashMap<>();
        TreeSet<Integer>dry=new TreeSet<>();
        
        int n=rains.length;
        int[]ans=new int[n];
        
        for(int i=0;i<n;i++){
            int val=rains[i];
            
            if(val==0){
                dry.add(i);
                ans[i]=1;
            }else{
                
                Integer id=lastRain.get(val);
                
                if(id==null){
                    lastRain.put(val,i);
                }else{
                    Integer dryThisDay=dry.higher(id);
                    
                    if(dryThisDay==null){
                        return new int[0];
                    }
                    
                    ans[dryThisDay]=val;
                    dry.remove(dryThisDay);
                    
                    lastRain.put(val,i);
                }
                ans[i]=-1;
            }
        }
        return ans;
    }
}