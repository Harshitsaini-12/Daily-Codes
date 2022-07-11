// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    // Function to detect cycle in a directed graph.
    bool isCycle( vector<int> adj[],int src,int vis[],int dfsvis[]){
        vis[src]=1;
        dfsvis[src]=1;
        
        for(auto it:adj[src]){
            if(!vis[it]){
                if(isCycle(adj,it,vis,dfsvis))return true;
            }else if(dfsvis[it]){
                return true;
            }
        }
        dfsvis[src]=0;
        return false;
    }
    
    bool isCyclic(int V, vector<int> adj[]) {
        // code here
        int vis[V];
        int dfsVis[V];
        
        memset(vis,0,sizeof vis);
        memset(dfsVis,0,sizeof dfsVis);
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(isCycle(adj,i,vis,dfsVis))return true;
            }
        }
        return false;
    }
};

// { Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";
    }

    return 0;
}
  // } Driver Code Ends