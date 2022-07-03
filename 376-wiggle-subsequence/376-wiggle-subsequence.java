class Solution {
    public int wiggleMaxLength(int[] nums) {
        int valley=1;
        int peak=1;
        
        int n=nums.length;
        
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])peak=valley+1;
            else if(nums[i-1]>nums[i])valley=peak+1;
        }
        
        return Math.max(valley,peak);
    }
}