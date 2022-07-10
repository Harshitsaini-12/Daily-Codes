class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length-1;
        int n=grid[0].length-1;
        
        return minPathSum_(grid,0,0,m,n,new HashMap<>());
    }
    
    
    public int minPathSum_(int[][]grid,int s,int e,int m,int n,HashMap<String,Integer>hm){
        if(s>m || e>n)return Integer.MAX_VALUE;
        
        if(s==m && e==n)return grid[s][e];
        
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        
        String key=s + "#" + e;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        if(s!=m){
            x=grid[s][e] + minPathSum_(grid,s+1,e,m,n,hm);
        }
        
        if(e!=n){
            y=grid[s][e] + minPathSum_(grid,s,e+1,m,n,hm);
        }
        
        hm.put(key,Math.min(x,y));
        return Math.min(x,y);
        
    }
}