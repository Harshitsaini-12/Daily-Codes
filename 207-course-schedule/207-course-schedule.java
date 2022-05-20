class Solution {
    
    public boolean dfs(int[]vis,ArrayList<Integer>[]graph,int src){
        vis[src]=1;
        
        for(int nbr:graph[src]){
            if(vis[nbr]==0){
                if(dfs(vis,graph,nbr))return true;
            }else if(vis[nbr]==1){
                return true;
            }
        }
        
        vis[src]=2;
        return false;
    }
    
    public boolean canFinish(int N, int[][] edges) {
        int[]vis=new int[N];
        ArrayList<Integer>[]graph=new ArrayList[N];
        
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int []edge:edges){
            int u=edge[1];
            int v=edge[0];
            
            graph[u].add(v);
        }
        
        for(int i=0;i<N;i++){
            if(vis[i]==0){
                boolean cycle=dfs(vis,graph,i);
                if(cycle)return false;
            }
        }
        
        return true;
    }
}