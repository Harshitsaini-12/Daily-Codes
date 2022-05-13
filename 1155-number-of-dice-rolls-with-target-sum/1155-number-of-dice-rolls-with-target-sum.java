class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        return (int)totalways(n,k,target,new HashMap<>())% 1000000007;
    }
    
    public long totalways(int d,int f,int target,HashMap<String,Long>hm){
        
        if(d==0 && target!=0)return 0;
        
        if(d==0 && target==0)return 1;
        
        long ans=0;
        
        String key=d+ "#" + target;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        for(int curr=1;curr<=f;curr++){
            long tempans=totalways(d-1,f,target-curr,hm)% 1000000007;
            ans+=tempans;
        }
        
        hm.put(key,ans);
        return ans% 1000000007;
    }
}