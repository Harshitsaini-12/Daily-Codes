class Solution {
  public void wordBreak_backEng(String s,List<String>ans,HashSet<String>set,int idx,boolean[]dp,int maxlen,List<String>wordDict,String asf){
      
      if(idx>=s.length()){
          ans.add(asf.substring(0,asf.length()-1));
          // System.out.println(ans);
          return;
      }
      
      for(int l=1;l<=maxlen && idx+l<=s.length();l++){
          if(dp[l+idx]){
              String substr=s.substring(idx,l+idx);
              
              if(set.contains(substr)){
                  wordBreak_backEng(s,ans,set,idx+l,dp,maxlen,wordDict,asf + substr + " ");
              }
          }
      }
        
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
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
          
          for(int l=1;l<=maxlen && l+i<=n;l++){
              String substr=s.substring(i,i+l);
              
              if(set.contains(substr)){
                  dp[l+i]=true;
              }
          }
       }
        List<String>ans=new ArrayList<>();
        
        if(dp[n]){
            wordBreak_backEng(s,ans,set,0,dp,maxlen,wordDict,"");
        }
        return ans;
    }
}