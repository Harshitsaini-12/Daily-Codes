class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String>set=new HashSet<>();
        
        int n=s.length();
        int len=0;
        
        for(String ss:wordDict){
            set.add(ss);
            len=Math.max(len,ss.length());
        }
        
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=0;i<=n;i++){
            if(!dp[i])continue;
            
            for(int l=1;l<=len && l+i<=n;l++){
                String substr=s.substring(i,i+l);
                
                if(set.contains(substr)){
                    dp[i+l]=true;
                }
            }
        }
        
        return dp[n];
    }
}