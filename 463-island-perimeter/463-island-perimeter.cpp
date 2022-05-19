class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int no_of_one=0;
        int nbrCount=0;
        
        int n=grid.size();
        int m=grid[0].size();
        
        vector<vector<int>>dirs={{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    no_of_one++;
                    
                    for(auto &dir:dirs){
                        int r=dir[0]+i;
                        int c=dir[1]+j;
                        
                          if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                             nbrCount++;
                          }
                    }
                  
                }
            }
        }
        
        return 4*no_of_one-nbrCount;
    }
};