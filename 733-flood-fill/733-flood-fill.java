class Pair{
    int x;
    int y;
    
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        
        if(grid[sr][sc]==newColor)return grid;
        
        int m=grid.length;
        int n=grid[0].length;
        
        int currentColor=grid[sr][sc];
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        
        while(q.size()>0){
            Pair currentPair=q.remove();
            int cr=currentPair.x;
            int cc=currentPair.y;
            
            if(cr<0 || cr>=m || cc<0 || cc>=n || grid[cr][cc]!=currentColor)continue;
            
            grid[cr][cc]=newColor;
            
            //up call
             q.add(new Pair(cr-1,cc));
            //down call
             q.add(new Pair(cr+1,cc));
            //left call
             q.add(new Pair(cr,cc-1));
            //right call
             q.add(new Pair(cr,cc+1));
        }
        
        return grid;
    }
}

// using bfs.