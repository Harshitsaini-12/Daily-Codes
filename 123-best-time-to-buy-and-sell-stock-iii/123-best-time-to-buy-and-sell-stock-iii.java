class Solution {
    public int maxProfit(int[] prices) {
        
       int[][][]dp = new int[prices.length][2][3];
        
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return ans(prices,0,1,2,dp);
    }
    
     public int ans(int[]prices,int ci,int canBuy,int trans,int[][][]arr){
        
        if(trans<=0 || prices.length<=ci){
            return 0;
        }
        
        if(arr[ci][canBuy][trans]!=-1){
            return arr[ci][canBuy][trans];
        }
         
       
         
        if(canBuy==1){
            int idle=ans(prices,ci+1,canBuy,trans,arr);
            int buy= -prices[ci] + ans(prices,ci+1,0,trans,arr);
            arr[ci][canBuy][trans]=Math.max(idle,buy);
            
            return Math.max(idle,buy);
            
        }else{
            int idle=ans(prices,ci+1,canBuy,trans,arr);
            int sell=prices[ci] + ans(prices,ci+1,1,trans-1,arr);
            arr[ci][canBuy][trans]= Math.max(idle,sell);
            
            return Math.max(idle,sell);
        }
         
    }
}