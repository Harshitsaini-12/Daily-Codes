class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        
        int sum=0;
        int sumF=0;
        
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
            sumF+=i*nums[i];
        }
        int maxsum=sumF;
        for(int i=0;i<n;i++){
            sumF=sumF-sum+n*nums[i];
            maxsum=Math.max(maxsum,sumF);
        }
        
        return maxsum;
    }
}