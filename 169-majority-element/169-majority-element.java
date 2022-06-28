class Solution {
    
   public int validate(int[]nums){
       int count=1;
       int val=nums[0];
       
       for(int i=1;i<nums.length;i++){
           if(nums[i]==val){
               count++;
           }else{
               count--;
           }
           
           if(count==0){
               val=nums[i];
               count=1;
           }
       }
       
       return val;
   }
    
    public int majorityElement(int[] nums) {
        int val=validate(nums);
        int count=0;
        
        for(int i=0;i<nums.length;i++){
            if(val==nums[i])count++;
        }
        
        if(count>nums.length/2){
            return val;
        }
        return val;
    }
}