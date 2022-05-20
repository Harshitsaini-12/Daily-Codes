// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
    bool bfs_bipartite(vector<int>adj[],vector<int>&colors,int src){
        int c=0; // lets start with the blue color
        
        queue<int>q;
        q.push(src);
        
        while(q.size()){
            int size=q.size();
            
            while(size--){
                int u=q.front();q.pop();
                
                if(colors[u]!=-1){
                    if(colors[u]!=c)return false;
                    continue;
                }
                
                colors[u]=c;
                
                for(int v:adj[u]){
                    if(colors[v]==-1){
                        q.push(v);
                    }
                }
            }
            c=(c+1)%2;
        }
        
        return true;
    }
    
	bool isBipartite(int V, vector<int>adj[]){
	    // Code here
        
        vector<int>colors(V,-1);
        
        for(int i=0;i<V;i++){
            if(colors[i]==-1){
                bool isBipartite=bfs_bipartite(adj,colors,i);
                
                if(!isBipartite)return false;
            }
        }
        return true;
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
			adj[v].push_back(u);
		}
		Solution obj;
		bool ans = obj.isBipartite(V, adj);    
		if(ans)cout << "1\n";
		else cout << "0\n";  
	}
	return 0;
}  // } Driver Code Ends