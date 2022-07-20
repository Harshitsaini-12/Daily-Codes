class Solution {
public:
    int change(int tar, vector<int>& arr) {
       int n=arr.size();
       vector<vector<int>>dp(n,vector<int>(tar+1,0));
  
        for(int T=0;T<=tar;T++){
            dp[0][T]=(T%arr[0]==0);
        }
        
        for(int idx=1;idx<n;idx++){
            for(int T=0;T<=tar;T++){
                int notTake=dp[idx-1][T];
                
                int take=0;
                if(arr[idx]<=T){
                    take = dp[idx][T-arr[idx]];
                }
                
                dp[idx][T]=take + notTake;
            }
        }
        
        return dp[n-1][tar];
    }
};

