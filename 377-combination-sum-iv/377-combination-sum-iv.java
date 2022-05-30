class Solution {
    
    public int combination(int[]nums,int Tar,int[]dp){
        dp[0]=1;
  
        
        for(int tar=1;tar<=Tar;tar++){
          int count=0;
            for(int elem:nums){
                if(tar-elem>=0){
                    count+=dp[tar-elem];
                }
            }
            dp[tar]=count;
        }
        
        return dp[Tar];
        
    }

    public int combinationSum4(int[] nums, int target) {
        
        int[]dp=new int[target+1];
        
        int ans=combination(nums,target,dp);
        return ans;
    }
}