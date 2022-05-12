class Solution {
public:    
   void helper(int index,vector<vector<int>>&ans,vector<int>&nums){
        
        if(index==nums.size()){
            ans.push_back(nums);
            return;
        }
       
        unordered_set<int>hm;
        for(int j=index;j<nums.size();j++){
             if(hm.find(nums[j])!=hm.end())continue;
            
                hm.insert(nums[j]);
                swap(nums[index],nums[j]);
                helper(index+1,ans,nums);
                swap(nums[index],nums[j]);
        }
    }
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>ans;
        vector<int>sans;
        helper(0,ans,nums);
        return ans;
    }
};