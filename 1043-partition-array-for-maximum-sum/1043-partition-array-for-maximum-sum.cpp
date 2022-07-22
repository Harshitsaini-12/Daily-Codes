class Solution {
public:
    
    int f(int idx,vector<int>&nums,int k,vector<int>&dp,int n){
        
        if(idx==n)return 0;
        
        if(dp[idx]!=-1)return dp[idx];
        
        int maxSum=INT_MIN;
        int maxElem=0;
        int len=0;
        
        for(int j=idx;j<min(idx+k,n);j++){
            
            maxElem=max(maxElem,nums[j]);
            len++;
            
            int sum = (len * maxElem ) + f(j+1,nums,k,dp,n);
            
            maxSum=max(maxSum,sum);
        }
    
        return dp[idx]=maxSum;
    }
    
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n=arr.size();
        vector<int>dp(n+1,-1);
        
        return f(0,arr,k,dp,n);
    }
};