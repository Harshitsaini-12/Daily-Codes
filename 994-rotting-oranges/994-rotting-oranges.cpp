class Solution {
public:
    vector<vector<int>>dir={{1,0},{-1,0},{0,1},{0,-1}};
    
    int orangesRotting(vector<vector<int>>& grid) {
        queue<int>q;
        int freshOranges=0;
        
        int n=grid.size();
        int m=grid[0].size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }else if(grid[i][j]==2){
                    q.push(i*m+j);
                }
            }
        }
        
        if(freshOranges==0)return 0;
        
        int level=0;
        
        while(q.size()!=0){
            int size=q.size();
            
            while(size-->0){
                int val=q.front();q.pop();
                
                int r=val/m;
                int c=val%m;
                
                for(auto &d:dir){
                 
                    int rr=r + d[0];
                    int cc=c + d[1];
                    
                    if(rr>=0 && cc>=0 && rr<n && cc<m && grid[rr][cc]==1){
                        grid[rr][cc]=2;
                        q.push(rr*m+cc);
                        freshOranges--;
                        
                        if(freshOranges==0)return level+1;
                    }
                }
                
            }
            level++;
        }
        return -1;
        
    }
};