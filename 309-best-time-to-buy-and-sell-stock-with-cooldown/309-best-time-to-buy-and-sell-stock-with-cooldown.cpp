class Solution {
public:
    int f(int idx,int canBuy,vector<int>&prices,vector<vector<int>>&dp,int n){
        
      if(idx>=n)return 0;
        
      if(dp[idx][canBuy]!=-1)return dp[idx][canBuy];
        
         if(canBuy==1){
    return dp[idx][canBuy]=max(f(idx+1,canBuy,prices,dp,n),-prices[idx] + f(idx+1,0,prices,dp,n));
         }else{
    return dp[idx][canBuy]=max(f(idx+1,canBuy,prices,dp,n),prices[idx] + f(idx+2,1,prices,dp,n));
         }
        
    }
    
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        vector<vector<int>>dp(n,vector<int>(2,-1));
        
        return f(0,1,prices,dp,n);
    }
};