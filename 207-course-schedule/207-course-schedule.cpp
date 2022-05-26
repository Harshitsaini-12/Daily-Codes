class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& edges) {
        vector<vector<int>>graph(n);
        vector<int>indegree(n,0);
        
        for(vector<int>&e:edges){
            graph[e[0]].push_back(e[1]);
            indegree[e[1]]++;
        }
        
        queue<int>q;
        for(int i=0;i<n;i++)if(indegree[i]==0)q.push(i);
        
        int vertexCount=0;
        
        while(q.size()!=0){
            int size=q.size();
            while(size-->0){
                int vtx=q.front();q.pop();
                vertexCount++;
                
                for(int v:graph[vtx]){
                    if(--indegree[v]==0){
                        q.push(v);
                    }
                }
            }
        }
        
        return vertexCount==n;
    }
};