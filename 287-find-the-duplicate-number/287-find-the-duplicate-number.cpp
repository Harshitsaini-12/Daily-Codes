class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        
        int slow=nums[0];
        int fast=nums[0];
        
        do{
            slow=nums[slow];
            fast=nums[nums[fast]]; 
        }while(slow!=fast);
        
            
        fast=nums[0];
        
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        
        return slow;
    }
};

        // sort(nums.begin(),nums.end());

        // int ans=0;
        // for(int i=0;i<nums.size()-1;i++){
        //     if(nums[i]==nums[i+1]){
        //         ans=nums[i];
        //     }
        // }
        // return ans;