class Solution {
    public int change(int amount, int[] coins) {
         return ans(coins,0,amount,new HashMap<String,Integer>());
    }
    public int ans(int[] coins, int index,int amount,HashMap<String,Integer>hm){
        if(amount==0)return 1;
        
        if(index>=coins.length)return 0;
        
        int consider=0;
        
        String key=Integer.toString(index)+"-"+Integer.toString(amount);
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        if(coins[index]<=amount){
            consider=ans(coins,index,amount-coins[index],hm);
        }
        
        int notConsider=ans(coins,index+1,amount,hm);
        
        hm.put(key,consider+notConsider);
        return consider+notConsider;
    }
    
    
}