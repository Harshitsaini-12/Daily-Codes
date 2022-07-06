class Solution {
    public int singleNonDuplicate(int[] nums) {
      int n=nums.length;
        
        if(n==1){
            return nums[0];
        }else if(nums[0]!=nums[1]){
            return nums[0];
        }else if(nums[n-1]!=nums[n-2])return nums[n-1];
        
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid=(low+high)>>1;
            
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])return nums[mid];
            
            else if(nums[mid]==nums[mid-1]){
                int count=mid-low+1;
                
                if((count&1)==0){
                    low=mid+1;
                }else{
                    high=mid-2;
                }
                
            }else if(nums[mid]==nums[mid+1]){
                  int count=high-mid+1;
                
                if((count&1)==0){
                       high=mid-1;
                  
                }else{
                   low=mid+2;
                }
            }
        }
        
        return -1;
    }
}