class Solution {
    public void dfs(int[][]matrix,int i,int j,int height,boolean[][]vis){
        
if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || height>matrix[i][j] || vis[i][j])return;
        
        vis[i][j]=true;
        
        dfs(matrix, i+1, j, matrix[i][j], vis);
        dfs(matrix, i-1, j, matrix[i][j], vis);
        dfs(matrix, i, j+1, matrix[i][j], vis);
        dfs(matrix, i, j-1, matrix[i][j], vis);
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>>ans=new ArrayList<>();
        
        int row=matrix.length;
        int col=matrix[0].length;
        
        if(row==0)return ans;
        
        boolean [][]pacific=new boolean[row][col];
        boolean [][]atlantic=new boolean[row][col];
        
        //moving in col from left from right
        for(int j=0;j<col;j++){
           dfs(matrix,0,j,matrix[0][j],pacific);
           dfs(matrix,row-1,j,matrix[row-1][j],atlantic);
        }
        
        //moving in row from left to right
        for(int i=0;i<row;i++){
           dfs(matrix,i,0,matrix[i][0],pacific);
           dfs(matrix,i,col-1,matrix[i][col-1],atlantic);
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer>sans=new ArrayList<>();
                    sans.add(i);
                    sans.add(j);
                    ans.add(sans);
                }
            }
        }
        
        return ans;
    }
}