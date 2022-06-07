class Solution {
    public int swimInWater(int[][] grid) {
        int[][]dir={{1,0},{0,1},{0,-1},{-1,0}};
        int n=grid.length;
        int m=grid[0].length;
        
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            int i1=a/m;int j1=a%m;
            int i2=b/m;int j2=b%m;
            
            return grid[i1][j1]-grid[i2][j2];
        });
        
        int minHeight=0;
        boolean[][]vis=new boolean[n][m];
        pq.add(0);
        vis[0][0]=true;
        
        while(pq.size()>0){
            int idx=pq.remove();
            
            int r=idx/m;
            int c=idx%m;
            int height=grid[r][c];
            
            minHeight=Math.max(minHeight,height);
            
            if(r==n-1 && c==m-1)break;
            
            for(int[]d:dir){
                int rr=d[0]+r;
                int cc=d[1]+c;
                
                if(rr>=0 && cc>=0 && rr<n && cc<m && !vis[rr][cc]){
                    vis[rr][cc]=true;
                    pq.add(rr * m + cc);
                }
            }
        }
        
        return minHeight;
    }
}