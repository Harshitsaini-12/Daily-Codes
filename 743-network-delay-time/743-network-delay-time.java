class Solution {
    
    public int dijkstra(ArrayList<int[]>[]graph,int n,int src){
        int[]dis=new int[n+1];
        boolean[]vis=new boolean[n+1];
        Arrays.fill(dis,(int)1e8);
        
        //{vtx,wsf}
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
           return a[1]-b[1]; 
        });
        
        pq.add(new int[]{src,0});
        
        while(pq.size()!=0){
            int[]p=pq.remove();
            
            int vtx=p[0];
            int wsf=p[1];
            
            if(vis[vtx])continue;
            
            vis[vtx]=true;
            dis[vtx]=wsf;
            
            for(int[]e:graph[vtx]){
                int v=e[0];
                int w=e[1];
                
                if(!vis[v]){
                    pq.add(new int[]{v,wsf+w});
                }
            }
        }
        
        int maxTime=0;
        
        for(int i=1;i<=n;i++){
            if(dis[i]==(int)1e8)return -1;
            maxTime=Math.max(maxTime,dis[i]);
        }
        
        return maxTime;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        //vtx,wt
        ArrayList<int[]>[]graph=new ArrayList[n+1];
        
        for(int i=0;i<=n;i++)graph[i]=new ArrayList<>();
        
        for(int[]time:times){
            graph[time[0]].add(new int[]{time[1],time[2]});
        }
        
        return dijkstra(graph,n,k);
    }
}