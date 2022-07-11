class Solution {
    //-1 : not visited , 0-red color ,1-- green color
    public boolean isBipartite(int[][]graph,int src,int[]vis){
       LinkedList<Integer>q=new LinkedList<>();
        
       int color=0;
        
       q.addLast(src);
        
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int vtx=q.removeFirst();
                
                if(vis[vtx]!=-1){
                    if(vis[vtx]!=color)return false;
                }
                
                vis[vtx]=color;
                
                for(int v:graph[vtx]){
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

