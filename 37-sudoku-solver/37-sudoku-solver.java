class Solution {
    
    private boolean isPossibleToPLace(char[][] board,int r,int c,int num){
        //col check
        for(int i=0;i<9;i++){
            if(board[i][c]-'0'==num)return false;
        }
        
        //row check
        for(int i=0;i<9;i++){
            if(board[r][i]-'0'==num)return false;
        }
        
        //check in 3*3 matrix
        r=(r/3)*3;
        c=(c/3)*3;
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                 if(board[r+i][c+j]-'0'==num)return false;
            }
        }
        return true;
    }
    
    public boolean SudokuSolver(char[][] board,ArrayList<Integer>list,int idx){
        if(idx==list.size())return true;
        
        //decode the values
        int r=list.get(idx)/9;
        int c=list.get(idx)%9;
        
        for(int num=1;num<=9;num++){
            if(isPossibleToPLace(board,r,c,num)){
                
                //place the char no by typecasting
                board[r][c]=(char)(num+('0'));
                
                //if the suduko is solved then return true
                if(SudokuSolver(board,list,idx+1))return true;
                
                //unplace
                board[r][c]='.';
            }
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        ArrayList<Integer>list=new ArrayList<>();
        int n=9;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')list.add(i*n+j);
            }
        }
        
        SudokuSolver(board,list,0);
    }
}