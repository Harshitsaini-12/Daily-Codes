class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         if(obstacleGrid[0][0]==1)
            return 0;
        
        int m=obstacleGrid.length-1;
        int n=obstacleGrid[0].length-1;
        
        return ans(obstacleGrid,0,0,m,n,new HashMap<String,Integer>());
    }
    
    public int ans(int[][] arr,int s,int e,int m,int n,HashMap<String,Integer>hm){
        
        
        if(s==m && e==n)return 1;
        
        if(s>m || e>n)return 0;
        
        
        String key=s+"_"+e;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        int x=0;
        int y=0;
        
        if(s!=m && arr[s+1][e]!=1){
             x=ans(arr,s+1,e,m,n,hm);
        }
        
        if(e!=n && arr[s][e+1]!=1 ){
             y=ans(arr,s,e+1,m,n,hm);
        }

        hm.put(key,x+y);
        return x+y;
  
    }
}