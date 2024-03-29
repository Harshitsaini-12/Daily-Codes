class Solution {
    public int eraseOverlapIntervals(int[][] points) {

        Arrays.sort(points,(a,b)->{
           if(a[0]>b[0]){
               return 1;
           }else if(a[0]==b[0]){
               return 0;
           }else{
               return -1;
           }
        });
        
        int count=0;
        int end=points[0][1];
        
        for(int i=1;i<points.length;i++){
            
            if(points[i][0]<end){
                end=Math.min(end,points[i][1]);
                count++;
              
            }else{
                 end=points[i][1];
            }
        }
        
        return count;
    }
}