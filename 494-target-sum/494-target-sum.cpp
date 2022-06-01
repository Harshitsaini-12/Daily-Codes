class Solution {
public:

    
    int ans(vector<int>&nums,int target,int index,unordered_map<string,int>&mp){
        if(index>=nums.size() && target!=0)return 0;
        
        if(index>=nums.size() && target==0)return 1;
        
        string key=to_string(index)+"_"+to_string(target);
        if(mp.find(key)!=mp.end())return mp[key];
        
        int x=ans(nums,nums[index]-target,index+1,mp);
        int y=ans(nums,nums[index]+target,index+1,mp);
        
        mp[key]=x+y;
        return x+y;
        
    }
    
    
    int findTargetSumWays(vector<int>& nums, int target) {
          unordered_map<string,int>mp;
            return ans(nums,target,0,mp);
    }
    
};