class Solution {
    public int countSubstrings(String s) {
        boolean [][]dp=new boolean[s.length()][s.length()];
        int count=0;
            
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<dp.length;j++,i++){
                
                if(gap==0)dp[i][j]=true;
                else if(gap==1){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    if(s.charAt(i)==s.charAt(j) &&  dp[i+1][j-1]){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                  if(dp[i][j])count++;
            }
        }
        
        return count++;
    }
}

// for printing the path

// public String lis_backEng(String s,int si,int ei,int[][]dp){
    
//     if(si>=ei){
//         return (ei==si?s.charAt(si)+"":"")
//     }
    
//     if(s.charAt(si)==s.charAt(ei)){
//         return s.charAt(si)+lis_backEng(s,si+1,ei-1,dp)+s.charAt(ei);
//     }else if(dp[si][ei-1]>dp[si+1][ei]){
//         return lis_backEng(s,si,ei-1,dp);
//     }else{
//         return lis_backEng(s,si+1,ei,dp);
//     }
// }
