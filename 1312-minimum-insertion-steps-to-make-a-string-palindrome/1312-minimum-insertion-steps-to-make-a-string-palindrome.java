class Solution {
    public int minInsertions(String S) {
        int n=S.length();
        int[][]dp=new int[S.length()][S.length()];
        int ans=longestPalinSubseq_(S,0,S.length()-1,dp);
        return n-ans;
    }
    
    public int longestPalinSubseq_(String s,int i,int j,int[][]dp){
        if(i>=j){
            return dp[i][j]=i==j?1:0;
        }
        
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        
        int a=longestPalinSubseq_(s,i+1,j-1,dp);
        int b=longestPalinSubseq_(s,i+1,j,dp);
        int c=longestPalinSubseq_(s,i,j-1,dp);
        
        if(s.charAt(i)==s.charAt(j)){
           return dp[i][j]=a+2;
        }else{
            return dp[i][j]=Math.max(b,c);
        }
    }
    
}