class Solution {
public:
    int sinkIsland(vector<vector<int>>& grid,int cr,int cc,int m,int n){
       if(cr<0 || cr>=m || cc<0 || cc>=n || grid[cr][cc]==0)return 0;
        
        grid[cr][cc]=0;
        
        //up call
        int a=sinkIsland(grid,cr-1,cc,m,n);
        //down call
        int b=sinkIsland(grid,cr+1,cc,m,n);
        //left call
        int c=sinkIsland(grid,cr,cc-1,m,n);
        //right call
        int d=sinkIsland(grid,cr,cc+1,m,n);
        
        return 1+a+b+c+d;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m=grid.size();
        int n=grid[0].size();
        
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(grid[i][j]==1){
                   ans=max(ans,sinkIsland(grid,i,j,m,n));
                }
            }
        }
        return ans;
    }
};