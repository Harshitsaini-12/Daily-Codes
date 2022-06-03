class Solution {
    int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
    int mod=(int)(1e9+7);
    
    public int findPaths_(int n,int m,int k,int sr,int sc,int[][][]dp){
        if(sr<0 || sc<0 || sr==n || sc==m){
            return k>=0 ? 1 :0;
        }
        
        if(k==0)return 0;
        
        if(dp[sr][sc][k]!=-1)return dp[sr][sc][k];
        int count=0;
        
        for(int []d:dir){
            int r=sr+d[0];
            int c=sc+d[1];
            
            count=(count + findPaths_(n,m,k-1,r,c,dp))%mod;
        }
        
        return dp[sr][sc][k]=count;
    }
    
    public int findPaths(int n, int m, int k, int r, int c) {
        int[][][]dp=new int[n+1][m+1][k+1];
        
        for(int[][]d:dp)for(int[]ds:d)Arrays.fill(ds,-1);
        
        return findPaths_(n,m,k,r,c,dp);
    }
}