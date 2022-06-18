class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>ans;
        
        for(int i=0;i<nums.size();i++){
            
            if(i>0 && nums[i]==nums[i-1])continue;
            
            int tar=-nums[i];
            int start=i+1;
            int end=nums.size()-1;
            
            while(start<end){
                if(nums[start]+nums[end]==tar){
                    vector<int>sans;
                    sans.push_back(nums[i]);
                    sans.push_back(nums[start]);
                    sans.push_back(nums[end]);
                    
                    ans.push_back(sans);
                    
                    while(start<end && nums[start]==nums[start+1])start++;
                    while(start<end && nums[end]==nums[end-1])end--;
                    
                    start++;
                    end--;
                }else if(nums[start]+nums[end]>tar){
                    end--;
                }else{
                    start++;
                }
            }
        }
        
        return ans;
    }
};