class Solution {
    HashMap<Integer,Integer>hm=new HashMap<>();
    
    public int minDays(int n) {
        
        if(n<=2)return n;
        
        if(hm.containsKey(n))return hm.get(n);
        
        int ans=1 + Math.min(n%2+minDays(n/2),n%3+minDays(n/3));
        hm.put(n,ans);
        
        return ans;
    }
}