class Solution {
    
    public int targetSum(int[]nums,int tar,int[][]dp,int n,int sum){
        if(n==0){
            return dp[n][sum]=tar==sum?1:0;
        }
        
        if(dp[n][sum]!=-1)return dp[n][sum];
        
        int count=0;
        
        count+=targetSum(nums,tar,dp,n-1,sum + nums[n-1]);
        count+=targetSum(nums,tar,dp,n-1,sum - nums[n-1]);
        
        return dp[n][sum]=count;
    }
    
    public int findTargetSumWays(int[] nums, int target) {

        int n=nums.length;
        
        int sum=0;
        for(int num:nums)sum+=num;
        
        if(target>sum || target<-sum)return 0;
        int[][]dp=new int[n+1][2*sum+1];
        
        for(int []d:dp)Arrays.fill(d,-1);
        
        return targetSum(nums,target+sum,dp,n,sum);
    }
}