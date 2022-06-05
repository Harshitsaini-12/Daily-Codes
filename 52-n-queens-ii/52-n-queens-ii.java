class Solution {
 public int totalNQueens(int n) {
        List<List<String>>answer=new ArrayList<>();
        
       char[][]grid=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        nQueens(grid,0,n,answer);
        return answer.size();
    }
    
    private void nQueens(char[][]grid,int r,int n,List<List<String>>ans){
        
        if(r==n){
            List<String> tempAns=convert(grid,n);
            
            ans.add(tempAns);
            return;
        }
        
        for(int c=0;c<n;c++){
            
            if(isValid(r,c,grid,n)){
                grid[r][c]='Q';
                nQueens(grid,r+1,n,ans);
                grid[r][c]='.';
            }
        }
        return;
    }
    
    private boolean isValid(int r,int c,char [][]grid,int n){
        return isRow(r,grid,n) && isCol(c,grid,n) && isDiagonal(grid,r,c,n);
    }
    
    private boolean isRow(int r,char[][]grid,int n){
        for(int j=0;j<n;j++){
            if(grid[r][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    
    private boolean isCol(int c,char[][] grid,int n){
         for(int i=0;i<n;i++){
            if(grid[i][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    
    private boolean isDiagonal(char[][]grid,int r,int c,int n){
        
        int i=r;
        int j=c;
        
        while(i>=0 && j>=0){
            if(grid[i][j]=='Q'){
                return false;
            }
            i--;
            j--;
        }

        i=r;
        j=c;
        
         while(i>=0 && j<n){
            if(grid[i][j]=='Q'){
                return false;
            }
             j++;
             i--;
        }
        
        i=r;
        j=c;
        
         while(i<n && j>=0){
            if(grid[i][j]=='Q'){
                return false;
            }
             j--;
             i++;
        }
        
        i=r;
        j=c;
        
         while(i<n && j<n){
            if(grid[i][j]=='Q'){
                return false;
            }
             j++;
             i++;
        }
        
        return true;
    }
    
    private List<String>convert(char[][]grid,int n){
        List<String>ans=new ArrayList<>();
        
        for(int c=0;c<n;c++){
            String temp="";
            for(int r=0;r<n;r++){
                temp+=grid[r][c];
            }
            ans.add(temp);
        }
        return ans;
    }
}