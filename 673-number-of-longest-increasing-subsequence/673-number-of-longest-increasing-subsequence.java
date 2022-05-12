class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        
        int maxlen=0;
        int maxcount=0;
        
        int[]dp=new int[n];
        int[]count=new int[n];
        
        for(int i=0;i<n;i++){
           dp[i]=1;
           count[i]=1;
            
            
          for(int j=i-1;j>=0;j--){
              if(nums[j]<nums[i]){
                  if(dp[j]+1==dp[i]){
                      count[i]+=count[j];
                      
                  }else if(dp[j]+1>dp[i]){
                      
                      dp[i]=dp[j]+1;
                      count[i]=count[j];
                  }
              }
          }
            
            if(dp[i]==maxlen)maxcount+=count[i];
            else if(dp[i]>maxlen){
                maxlen=dp[i];
                maxcount=count[i];
            }
        }
        
        return maxcount;
    }
}