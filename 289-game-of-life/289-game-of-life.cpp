class Solution {
public:
    bool isValid(int x,int y,vector<vector<int>>& board){
        return (x>=0 && y>=0 && x<board.size() && y<board[0].size());
    }
    
    void gameOfLife(vector<vector<int>>& board) {
      vector<int>xi={0,0,1,1,1,-1,-1,-1};
      vector<int>yi={1,-1,1,-1,0,0,1,-1};
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                int count=0;
                
            for(int dir=0;dir<8;dir++){
                int x=i+xi[dir];
                int y=j+yi[dir];
                
                if(isValid(x,y,board) && abs(board[x][y])==1){
                    count++;
                }
            }
                
            if(board[i][j]==1 && (count<2 || count>3)){
                board[i][j]=-1;
            }
                
            if(board[i][j]==0 && count==3){
                board[i][j]=2;
            }
             
            }
        }
        
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]>=1){
                    board[i][j]=1;
                }else{
                    board[i][j]=0;
                }
            }
        }
    }
};