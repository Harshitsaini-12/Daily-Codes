class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
          //we are making it of double otherwise typecasting will take place
          int n=position.length;
          double[][]cardata=new double[n][2];
        //o --> position
        //1 --> time
        
        for(int i=0;i<n;i++){
           cardata[i][0]=position[i];
           cardata[i][1]=((target-position[i])*1d)/speed[i];
        }
        
        //sorting on basis on position
        Arrays.sort(cardata,(a,b)->{
            return (int)(a[0]-b[0]);
        });

        
        int nof=1;
        double tt=cardata[n-1][1];
        
        for(int i=n-2;i>=0;i--){
            if(cardata[i][1]>tt){
                nof++;
                tt=cardata[i][1];
            }
        }
        
        return nof;
        
    }
}