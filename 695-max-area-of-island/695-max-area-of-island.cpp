class Solution {
public:
    vector<int>par,size;
    int findPar(int u){
        return par[u]==u ? u : par[u]=findPar(par[u]);
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        
        if(n==0)return 0;
        
        for(int i=0;i<n*m;i++){
            par.push_back(i);
            size.push_back(1);
        }
        
        vector<vector<int>>dir{{0,1},{1,0},{-1,0},{0,-1}};
        int maxi=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                     int p1=findPar(i * m + j);
                
                    for(auto &d:dir){
                        int r=d[0] + i;
                        int c=d[1] + j;

                        if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                            int p2=findPar( r*m +c);
                            if(p1!=p2){
                                par[p2]=p1;
                                size[p1]+=size[p2];
                            }
                        }

                    }
                    maxi=max(maxi,size[p1]);
                }
                
            }
            
        }
        
        return maxi;
    }
};