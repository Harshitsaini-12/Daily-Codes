// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution 
{
    public:
    //Function to find a Mother Vertex in the Graph.
    void dfs_motherVertex(vector<int>graph[],int src,vector<bool>&vis){
        
        vis[src]=true;
        
        for(int v:graph[src]){
            if(!vis[v]){
                dfs_motherVertex(graph,v,vis);
            }
        }
        
    }
    
    int dfs(vector<int>graph[],int src,vector<bool>&vis){
         vis[src]=true;
         int size=1;
        
        for(int v:graph[src]){
            if(!vis[v]){
                size+=dfs(graph,v,vis);
            }
        }
        return size;
    }
    
	int findMotherVertex(int V, vector<int>graph[])
	{
	    // Code here
	    vector<bool>vis(V,false);
	    
	    int lastvtx=-1;
	    for(int i=0;i<V;i++){
	        if(!vis[i]){
	            dfs_motherVertex(graph,i,vis);
	            lastvtx=i;
	        }
	    }
	    
	    vis.clear();
	    vis.resize(V,false);
	    
	    int count=dfs(graph,lastvtx,vis);
	    return count==V?lastvtx:-1;
	}

};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int V, E;
		cin >> V >> E;
		vector<int>adj[V];
		for(int i = 0; i < E; i++){
			int u, v;
			cin >> u >> v;
			adj[u].push_back(v);
		}
		Solution obj;
		int ans = obj.findMotherVertex(V, adj);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends