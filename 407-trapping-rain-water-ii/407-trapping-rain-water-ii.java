class Solution {
    public int trapRainWater(int[][] height) {
        int n=height.length;
        int m=height[0].length;
        
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        boolean[][]vis=new boolean[n][m];
        
        int water=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==m-1 || j==0){
                    pq.add(new Pair(i,j,height[i][j]));
                    vis[i][j]=true;
                }
            }
        }
        
        int[][]dirs={{0,1},{1,0},{-1,0},{0,-1}};
        
        while(pq.size()>0){
         
            Pair rem=pq.remove();
            
            for(int[]dir:dirs){
                int x=dir[0] + rem.row;
                int y=dir[1] + rem.col;
                
                if(x>=0 && y>=0 && x<n && y<m && !vis[x][y]){
                    
                    water+=Math.max(0, rem.height - height[x][y] );
                    vis[x][y]=true;
                    
                    if(rem.height >= height[x][y]){
                        pq.add(new Pair(x,y,rem.height));
                    }else{
                        pq.add(new Pair(x,y,height[x][y]));
                    }
                }
            }
            
        }
        
        return water;
    }
    
    public class Pair implements Comparable<Pair>{
        int row;
        int col;
        int height;
        
        Pair(int row,int col,int height){
            this.row=row;
            this.col=col;
            this.height=height;
        }
        
        public int compareTo(Pair o){
            return this.height-o.height;
        }
    }
}