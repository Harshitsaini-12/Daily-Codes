class Solution {
public:
    int equalPairs(vector<vector<int>>& grid) {
        map<vector<int>,int>hm;
        int ans=0;
        
        for(int i=0;i<grid.size();i++){
            hm[grid[i]]++;
        }
        
        for(int j=0;j<grid[0].size();j++){
            vector<int>temp;
            
            for(int i=0;i<grid.size();i++){
                temp.push_back(grid[i][j]);
            }
            
            ans+=hm[temp];
        }
        
        return ans;
    }
};