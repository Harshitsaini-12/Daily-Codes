class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int maxi=nums[0];
        
        for(int i=1;i<nums.size();i++)maxi=max(maxi,nums[i]);
        
        int count=1;
        int ans=1;
        
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]==maxi && nums[i]==nums[i+1]){
                count++;
            }else{
                count=1;
            }
            
            ans=max(ans,count);
        }
        
        return ans;
    }
};