class Solution {
public:
    
    bool bfs_bipartite(vector<vector<int>>& graph,vector<int>&colors,int src){
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
                
                for(int v:graph[u]){
                    if(colors[v]==-1){
                        q.push(v);
                    }
                }
            }
            c=(c+1)%2;
        }
        
        return true;
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        int V=graph.size();
        
        vector<int>colors(V,-1);
        
        for(int i=0;i<V;i++){
            if(colors[i]==-1){
                bool isBipartite=bfs_bipartite(graph,colors,i);
                
                if(!isBipartite)return false;
            }
        }
        return true;
    }
};


// -1 --> unvisited
// 0 --> blue
//1 --> green