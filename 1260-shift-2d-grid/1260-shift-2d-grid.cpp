class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        
        int m=grid.size();
        int n=grid[0].size();
        vector<int>v;
        
        for(auto &i:grid){
            for(auto &j:i){
                v.push_back(j);
            }
        }
        
        k=k%v.size();
        
        reverse(v,0,v.size()-k-1);
        reverse(v,v.size()-k,v.size()-1);
        reverse(v,0,v.size()-1);
        
        int p=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=v[p];
                p++;
            }
        }

        return grid;
    }
    
    void reverse(vector<int>&v,int start,int end){
        
        for(int i=start,j=end;i<j;i++,j--){
            swap(v[i],v[j]);
        }
    }
};