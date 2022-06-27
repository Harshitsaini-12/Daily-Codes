class Solution {
    public int climbStairs(int n) {
        return totalways(0,n,new HashMap<Integer,Integer>());
    }
    
    public int totalways(int start,int total,HashMap<Integer,Integer>memo){
        
        if(start==total)return 1;
        
        if(start>total)return 0;
        
        int currkey=start;
        
        if(memo.containsKey(currkey)){
            return memo.get(currkey);
        }
        
        int ans1=totalways(start+1,total,memo);
        int ans2=totalways(start+2,total,memo);
        
        memo.put(start,ans1+ans2);
        return ans1+ans2;
        
    }
}