class Solution {
    public int coinChange(int[] coins, int amount) {
//         int x=ans(coins,0,amount,new HashMap<String,Integer>());
        
//         if(x==100000)return -1;
        
//         return x;
//     }
    
//     public int ans(int[] coins, int index,int amount,HashMap<String,Integer>hm){
//        if(amount==0)return 0;
        
//         if(index>=coins.length){
//             return 100000;
//         }
        
//         int consider=100000;
        
//         String s=Integer.toString(index)+"#"+Integer.toString(amount);
        
//         if(hm.containsKey(s)){
//             return hm.get(s);
//         }
        
//         if(coins[index]<=amount){
//             consider=1+ans(coins,index,amount-coins[index],hm);
//         }
        
//         int notConsider=ans(coins,index+1,amount,hm);
        
//         hm.put(s,Math.min(consider,notConsider));
        
//         return Math.min(consider,notConsider);
//     }
   int[] dp = new int[amount + 1];
        for (int target = 1; target < dp.length; target++) {
            dp[target] = dp.length;
            for (int coin : coins) {
                if (target >= coin) {
                    dp[target] = Math.min(dp[target], dp[target - coin] + 1);
                }
            }
        }
        return dp[amount] == dp.length ? -1 : dp[amount];
}
}