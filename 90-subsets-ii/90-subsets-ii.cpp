class Solution {
    
private:
    void generateSubsets(int index,vector<int>&sans,vector<vector<int>>&ans,vector<int>& nums){
        ans.push_back(sans);
        
        for(int i=index;i<nums.size();i++){
            if(i!=index && nums[i]==nums[i-1])continue;
            
            sans.push_back(nums[i]);
            generateSubsets(i+1,sans,ans,nums);
            sans.pop_back();
        }
    }
    
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>>ans;
        vector<int>sans;
        sort(nums.begin(),nums.end());
        
        generateSubsets(0,sans,ans,nums);
        return ans;
    }
};