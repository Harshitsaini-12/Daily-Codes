class Solution {
    //variation of catalan number
    public int numTrees(int n) {
        return helper(n,new HashMap<>());
    }
    
    private int helper(int n,HashMap<Integer,Integer>hm){
        
        if(n<=1)return 1;
        
        int ways=0;
        int key=n;
        
        if(hm.containsKey(key))return hm.get(key);
        
        for(int i=0;i<n;i++){
            ways+=helper(i,hm)*helper(n-i-1,hm);
        }
        
        hm.put(key,ways);
        return ways;
    }
}