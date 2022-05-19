class Solution {
public:
    vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
    
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n=matrix.size();
        int m=matrix[0].size();
        int longestPath=0;
        
        vector<vector<int>>dp(n,vector<int>(m));
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                longestPath=max(longestPath,dfs(matrix,i,j,n,m,dp));
            }
        }
        
        return longestPath;
    }
    
    int dfs(vector<vector<int>>& matrix,int r,int c,int n,int m,vector<vector<int>>&dp){
        int maxPath=0;
        
        if(dp[r][c]>0){
            return dp[r][c];
        }
        
        for(auto dir:dirs){
            int rr=r+dir[0];
            int cc=c+dir[1];
            
            if(rr>=0 && cc>=0 && rr<n && cc<m && matrix[rr][cc]>matrix[r][c]){
               maxPath=max(maxPath,dfs(matrix,rr,cc,n,m,dp));
            }
        }
        
        return dp[r][c]=maxPath+1;
    }
};