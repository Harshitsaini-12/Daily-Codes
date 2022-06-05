class Solution {
    
    public int rob(int[]nums,int si,int ei,int[]dp){
        if(si>ei)return 0;
        
        if(dp[si]!=-1)return dp[si];
        
        int rob=nums[si] + rob(nums,si+2,ei,dp);
        int notrob=rob(nums,si+1,ei,dp);
        
        return dp[si]=Math.max(rob,notrob);
    }
    
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==0 || n==1)return n==1 ? nums[0] : 1;
        
        int[]dp1=new int[n+1];
        int[]dp2=new int[n+1];
        
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        
        return Math.max(rob(nums,0,n-2,dp1),rob(nums,1,n-1,dp2));        
    }
}