class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& edges) {
        vector<vector<int>>graph(n);
        vector<int>indegree(n,0);
        
        vector<int>ans;
        
        for(vector<int>&e:edges){
            graph[e[1]].push_back(e[0]);
            indegree[e[0]]++;
        }
        
        queue<int>q;
        for(int i=0;i<n;i++)if(indegree[i]==0)q.push(i);
        
        while(q.size()!=0){
            int size=q.size();
            while(size-->0){
                int vtx=q.front();q.pop();

                ans.push_back(vtx);
                
                for(int v:graph[vtx]){
                    if(--indegree[v]==0){
                        q.push(v);
                    }
                }
            }
        }
        
        if(n!=ans.size())ans.clear();
        
        return ans;
    }
};