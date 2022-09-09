class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        
        Arrays.sort(p,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1];
            }
        });
        
        
        int count=0;
        int len=p.length-1;
        
        int max=p[len][1];
        
        for(int i=len-1;i>=0;i--){
            if(p[i][1]<max)count++;
            
            max=Math.max(max,p[i][1]);
        }
        
        
        return count;
        
    }
}