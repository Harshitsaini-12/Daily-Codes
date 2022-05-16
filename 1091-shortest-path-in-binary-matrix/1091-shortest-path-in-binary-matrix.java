class Solution {
    public class Pair{
        int i;
        int j;
        int path;
        
        Pair(int i,int j,int path){
            this.i=i;
            this.j=j;
            this.path=path;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        
        int m=grid.length;
        int n=grid[0].length;
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        grid[0][0]=1;
        
        int[][]dir={{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        while(q.size()!=0){
            int size=q.size();
            
            while(size-->0){
                Pair rem=q.poll();
                
                if(rem.i==m-1 && rem.j==n-1){
                    return rem.path;
                }
                
                for(int []d:dir){
                    int r=d[0]+rem.i;
                    int c=d[1]+rem.j;
                    
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==0){
                        q.add(new Pair(r,c,rem.path+1));
                        grid[r][c]=1;
                    }
                }
            }
        }
        return -1;
        
    }
}