class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
         HashSet<String>set=new HashSet<>();
        
         int maxLen=0;
         for(String ss:wordDict){
            set.add(ss);
             maxLen=Math.max(maxLen,ss.length());
         }
        
        boolean[]dp=new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=0;i<=s.length();i++){
            if(!dp[i])continue;
            
            for(int l=1;l<=maxLen && i+l<=s.length();l++){
                String substr=s.substring(i,l+i);
                
                if(set.contains(substr)){
                    dp[l+i]=true;
                }
            }
        }
        return dp[s.length()];
    }
}