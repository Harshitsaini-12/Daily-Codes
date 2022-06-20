class Solution {
    public int maxProfit(int[] prices) {
        return ans(prices,0,1,new HashMap<String,Integer>());
    }
    
    public int ans(int[]prices,int ci,int canBuy,HashMap<String,Integer>hm){
        
        
        if(ci>=prices.length){
            return 0;
        }
        
        String key=ci+"#"+canBuy;
        
            if(hm.containsKey(key)){
                return hm.get(key);
            }
        
        if(canBuy==1){
            int idle=ans(prices,ci+1,canBuy,hm);
            int buy= -prices[ci] + ans(prices,ci+1,0,hm);
            
            hm.put(key,Math.max(idle,buy));
            return Math.max(idle,buy);
            
        }else{
           int idle=ans(prices,ci+1,canBuy,hm);
           int sell=prices[ci] + ans(prices,ci+1,1,hm);
            
            hm.put(key,Math.max(idle,sell));
            return Math.max(idle,sell);
        }
    }
}