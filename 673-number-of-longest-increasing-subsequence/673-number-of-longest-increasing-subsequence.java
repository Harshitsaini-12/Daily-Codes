class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int maxcount=0;
        int maxlen=0;
        
        int[]dp=new int[n+1];
        int[]count=new int[n+1];
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            count[i]=1;
            
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    if(dp[j]+1==dp[i])count[i]+=count[j];
                    else if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                }
            }
            
            if(maxlen==dp[i])maxcount+=count[i];
            else if(maxlen<dp[i]){
                maxlen=dp[i];
                maxcount=count[i];
            }
        }
        
         return maxcount;
        
    }
}