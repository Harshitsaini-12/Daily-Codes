class Solution {
    public int findMin(int[] nums) {
        
        int start=0;
        int end=nums.length-1;
        
        if(nums[start]<=nums[end])return nums[start];
        
        while(start<=end){
            int mid=start+((end-start)/2);
            
            if(nums[mid+1]<nums[mid])return nums[mid+1];
            
            if(nums[mid]<nums[mid-1] && nums[mid]<nums[mid+1])return nums[mid];
            
            if(nums[start]<=nums[mid])start=mid+1;
            else{
                end=mid-1;
            }
            
        }
        
        return -1;
    }
}