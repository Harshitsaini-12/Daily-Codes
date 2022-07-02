class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>();
        
        int maxlen=0;
        
        for(String ss:wordDict){
            set.add(ss);
            maxlen=Math.max(maxlen,ss.length());
        }
        
        int n=s.length();
        
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=0;i<=n;i++){
            if(!dp[i])continue;
            
            for(int l=1;l<=maxlen && i+l<=n;l++){
                String substr=s.substring(i,i+l);
                
                if(set.contains(substr)){
                    dp[i+l]=true;
                }
            }
        }
        
        return dp[n];
    }
}