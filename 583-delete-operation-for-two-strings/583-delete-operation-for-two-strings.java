class Solution {
    
    public int lcs(String s,String t,int n,int m,int[][]dp){
        
        if(n==0 || m==0)return dp[n][m]=0;
        
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        
        int a=lcs(s,t,n-1,m-1,dp);
        int b=lcs(s,t,n-1,m,dp);
        int c=lcs(s,t,n,m-1,dp);
        
        if(s.charAt(n-1)==t.charAt(m-1)){
            return dp[n][m]=a+1;
        }else{
           return dp[n][m]=Math.max(b,c);
        }
    }
    
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        
        int[][] dp=new int[n+1][m+1];
        
        for(int[]d:dp)Arrays.fill(d,-1);
        int ans=lcs(word1,word2,n,m,dp);
        
        return n + m - 2 * ans;
    }
}

// we find the lcs of two strings and then minus the extra charcters that we have to delte this will give us count of deleted characters.

