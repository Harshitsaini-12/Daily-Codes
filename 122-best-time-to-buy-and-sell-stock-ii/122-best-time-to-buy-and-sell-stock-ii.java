class Solution {
    public int maxProfit(int[] prices) {
        return ans(prices,0,1,new HashMap<String,Integer>());
    }
    
    public int ans(int[]prices,int ci,int canBuy,HashMap<String,Integer>hm){
        
        
        if(ci>=prices.length)return 0;
        
        String key=ci+"#"+canBuy;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        
        if(canBuy==1){
            int idle=ans(prices,ci+1,canBuy,hm);
            int buy=-prices[ci] + ans(prices,ci+1,0,hm);
            
            int ans=Math.max(idle,buy);
            hm.put(key,ans);
            return ans;
        }else{
            int idle=ans(prices,ci+1,canBuy,hm);
            int sell=prices[ci] + ans(prices,ci+1,1,hm);
            
            int ans=Math.max(idle,sell);
            hm.put(key,ans);
            return ans;
        }
    }
}