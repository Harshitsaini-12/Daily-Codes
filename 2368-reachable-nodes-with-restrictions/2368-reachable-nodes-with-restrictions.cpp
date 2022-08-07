class Solution {
public:
    
    int dfs(vector<int>graph[],vector<int>&vis,int src){
        if(vis[src])return 0;
        
        //marking the vis as true
        vis[src]=1;
        int res=1;
        
        for(auto edge:graph[src]){
            if(!vis[edge]){
                res+=dfs(graph,vis,edge);
            }
        }
        
        return res;
    }
    
    
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        vector<int>vis(n,0);
        
        for(auto x:restricted)vis[x]=1;
        
        vector<int>graph[n];
        
        for(auto edge:edges){
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        return dfs(graph,vis,0);
    }
};