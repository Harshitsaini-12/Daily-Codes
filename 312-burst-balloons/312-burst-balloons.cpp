class Solution {
public:
    
//     int f(int i,int j,vector<int>&nums,vector<vector<int>>&dp){
//         if(i>j)return 0;
        
//         int maxi=-(1e9);
        
//         if(dp[i][j]!=-1)return dp[i][j];
        
//         for(int cut=i;cut<=j;cut++){
//         int cost = (nums[i-1] * nums[cut] * nums[j+1]) + f(i,cut-1,nums,dp) + f(cut+1,j,nums,dp);
            
//             maxi=max(maxi,cost);
//         }
        
//         return dp[i][j]=maxi;
//     }
    
    
    int maxCoins(vector<int>& nums) {
        int n=nums.size();
        vector<vector<int>>dp(n+2,vector<int>(n+2,0));
       
        nums.push_back(1);
        nums.insert(nums.begin(),1);
        
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                
                if(i>j)continue;
        
                int maxi=-(1e9);

                for(int cut=i;cut<=j;cut++){
                     int cost = (nums[i-1] * nums[cut] * nums[j+1]) +dp[i][cut-1]+ dp[cut+1][j];                                         
                     maxi=max(maxi,cost);
                }

                dp[i][j]=maxi;
            }
        }
        
        return dp[1][n];
            
    }
};