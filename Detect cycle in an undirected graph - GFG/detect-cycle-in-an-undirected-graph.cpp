// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
    bool checkCycle(vector<int> edges[],int src,vector<int>&vis){
    queue<pair<int,int>>q;
    vis[src]=true;
    q.push({src,-1});
    
    
    while(!q.empty()){
        int node=q.front().first;
        int pre=q.front().second;
        
        q.pop();
        
        for(auto it:edges[node]){
            if(!vis[it]){
                vis[it]=true;
                q.push({it,node});
            }else if(pre!=it){
                return true;
            }
        }
    }
    return false;
    
}
  public:
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {
        // Code here
         vector<int>vis(V+1,0);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkCycle(adj,i,vis))return true;
            }
        }
        return false;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}  // } Driver Code Ends