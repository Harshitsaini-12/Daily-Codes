class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        int[][]ans=new int[m-2][m-2];
        
        for(int i=0;i<n-2;i++){
            for(int j=0;j<n-2;j++){
                ans[i][j]=findMax(i,j,grid);
            }
        }
        
        return ans;
    }
    
    public int findMax(int i,int j,int[][]grid){
        
        int maxVal=Integer.MIN_VALUE;
        
        for(int x=i;x<i+3;x++){
            for(int y=j;y<j+3;y++){
                maxVal=Math.max(maxVal,grid[x][y]);
            }
        }
        
        return maxVal;
    }
}