class Solution {
    
    public boolean isBipartite(int[][]graph,int src,int[]vis){
        LinkedList<Integer>q=new LinkedList<>();
        q.addLast(src);
        
        int color=0;
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int val=q.removeFirst();
                
                if(vis[val]!=-1){
                    if(vis[val]!=color)return false;
                    continue;
                }
                
                vis[val]=color;
                for(int v:graph[val]){
                    if(vis[v]==-1){
                        q.addLast(v);
                    }
                }
            }
            color=(color+1)%2;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        
        int[]vis=new int[n];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<n;i++){
            if(vis[i]==-1 && !isBipartite(graph,i,vis))return false;
        }
        return true;
    }
}

