class Solution {
    
    public boolean canPartitionKSubsets_(int[]nums,int idx,int k,boolean[]vis,int tar,int sumSF){
        if(k==0)return true;
        
        if(tar<sumSF)return false;
        
        if(sumSF==tar){
            return canPartitionKSubsets_(nums,0,k-1,vis,tar,0);
        }
        
        boolean res=false;
        
        for(int i=idx;i<nums.length;i++){
            if(vis[i])continue;
            
            vis[i]=true;
            res = res || canPartitionKSubsets_(nums,i+1,k,vis,tar,sumSF+nums[i]);
            vis[i]=false;
        }
        
        return res;
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int max=0;
        
        for(int val:nums){
            sum+=val;
            max=Math.max(max,val);
        }
        
        if(sum%k!=0 || max>sum/k)return false;
        boolean[]vis=new boolean[n];
        
        return canPartitionKSubsets_(nums,0,k,vis,sum/k,0);
        
    }
}