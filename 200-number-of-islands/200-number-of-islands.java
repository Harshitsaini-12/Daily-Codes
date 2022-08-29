class Solution {
    public int numIslands(char[][] grid) {
        int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,dir);
                }
            }
        }
        return count;
    }
    
    public void dfs(int r,int c,char[][]grid,int[][]dir){
        
        grid[r][c]='0';
        
        for(int i=0;i<dir.length;i++){
            int rr=r+dir[i][0];
            int cc=c+dir[i][1];
            
            if(rr>=0 && cc>=0 && rr<grid.length && cc<grid[0].length && grid[rr][cc]=='1'){
                dfs(rr,cc,grid,dir);
            }
        }
        
    }
}