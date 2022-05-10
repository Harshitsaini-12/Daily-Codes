class Solution {
    public int lengthOfLIS(int[] nums) {
//         int ans=1;
//         int n=nums.length;
        
//         int[]dp=new int[n];
//         Arrays.fill(dp,1);
        
//         for(int i=1;i<dp.length;i++){
//             for(int j=0;j<i;j++){
//                 if(nums[j]<nums[i]){
//                     dp[i]=Math.max(dp[i],dp[j]+1);
//                     ans=Math.max(ans,dp[i]);
//                 }
//             }
//         }
//         return ans;
        
        int n=nums.length;
        int []dp=new int[n];
        int maxlen=0;
        
        for(int i=0;i<n;i++){
            maxlen=Math.max(maxlen,lis(nums,i,dp));
        }
        
        return maxlen;
    }
    
    private int lis(int[]nums,int idx,int[]dp){
        int maxlen=1;
        
        if(dp[idx]!=0){
            return dp[idx];
        }
        
        for(int i=idx-1;i>=0;i--){
            if(nums[idx]>nums[i]){
                int ans=lis(nums,i,dp);
                maxlen=Math.max(maxlen,ans+1);
            }
        }
        
        return dp[idx]=maxlen;
    }
}