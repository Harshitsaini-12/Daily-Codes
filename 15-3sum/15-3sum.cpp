class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>res;
        
        for(int i=0;i<nums.size();i++){
            
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            int lo=i+1;
            int hi=nums.size()-1;
            int tar=-nums[i];
            
            while(lo<hi){
                if(nums[lo]+nums[hi]==tar){
                    vector<int>ans;
                    ans.push_back(nums[i]);
                    ans.push_back(nums[lo]);
                    ans.push_back(nums[hi]);
                    
                    res.push_back(ans);
                    
                    while(lo<hi && nums[lo]==nums[lo+1])lo++;
                    while(lo<hi && nums[hi]==nums[hi-1])hi--;
                    
                    lo++;
                    hi--;
                }else if(nums[lo]+nums[hi]>tar){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        
        return res;
    }
};