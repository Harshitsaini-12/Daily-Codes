class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    grid[i][j]=color;
                }
            }
        }
        
        return grid;
    }
    
    int [][]dir={{0,1},{-1,0},{1,0},{0,-1}};
    public void dfs(int[][] grid, int row, int col,int clr){
        grid[row][col]=-clr;
        int count=0;
        
        for(int i=0;i<4;i++){
            int rdash=row+dir[i][0];
            int cdash=col+dir[i][1];
            
            if(rdash<0 || cdash<0 || rdash>=grid.length || cdash>=grid[0].length ||                                 Math.abs(grid[rdash][cdash])!=clr)continue;
            
            count++;
            
            if(grid[rdash][cdash]==clr){
                dfs(grid,rdash,cdash,clr);
            }
        }
        
        if(count==4){
            grid[row][col]=clr;
        }
    }
}