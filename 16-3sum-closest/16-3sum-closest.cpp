class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
         sort(nums.begin(),nums.end());
        int diff=INT_MAX;
        int ans=0;
        
        for(int i=0;i<nums.size();i++){
            int val=nums[i];
            int start=i+1;
            int end=nums.size()-1;
            
            while(start<end){
                if(nums[start]+nums[end]+val==target)return target;
                else if(abs(nums[start]+nums[end]+val-target)<diff){
                    diff=abs(nums[start]+nums[end]+val-target);
                    ans=nums[start] + nums[end] + val;
                }
                
                if(val+nums[start]+nums[end]<target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
};