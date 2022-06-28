class Solution {
    public int uniquePaths(int m, int n) {
        return ans(0,0,m-1,n-1,new HashMap<String,Integer>());
    }
    
    public int ans(int r,int c,int m,int n,HashMap<String,Integer>hm){
        
        if(r==m && c==n){
            return 1;
        }
        
        if(r>m || c>n){
            return 0;
        }
        
        String key=r+"_"+c;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        int x=ans(r+1,c,m,n,hm);
        int y=ans(r,c+1,m,n,hm);
        
        hm.put(key,x+y);
        return x+y;
        
    }
}