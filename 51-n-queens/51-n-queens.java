class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans=new ArrayList<>();
        
        char[][]grid=new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]='.';
            }
        }
        
        solve(grid,n,ans,0);
        return ans;
    }
    
    public void solve(char[][]grid,int n,List<List<String>>ans,int r){
        
        if(r==n){
            List<String>sans=convert(grid,n);
            ans.add(sans);
            return;
        }
        
        for(int c=0;c<n;c++){
            if(isValid(grid,r,c,n)){
                grid[r][c]='Q';
                solve(grid,n,ans,r+1);
                grid[r][c]='.';
            }
        } 
        return;
    }
    
    public boolean isValid(char[][]grid,int r,int c,int n){
        return isCol(grid,r,c,n)&& isRow(grid,r,c,n) && isDiagonal(grid,r,c,n);
    }
    
    private boolean isRow(char[][]grid,int r,int c,int n){
        for(int j=0;j<n;j++){
            if(grid[r][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    
    private boolean isCol(char[][]grid,int r,int c,int n){
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
    
    public List<String>convert(char[][]grid,int n){
        List<String>list=new ArrayList<>();
        
        for(int j=0;j<n;j++){
              String temp="";
            for(int i=0;i<n;i++){
                temp+=grid[i][j];
            }
            list.add(temp);
        }
        return list;
    }
}