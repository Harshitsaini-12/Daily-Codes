class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size()==0)return 0;
        
        int res=1;
        
        for(int j=1;j<nums.size();j++){
            if(nums[j]!=nums[res-1]){
                nums[res]=nums[j];
                res++;
            }
        }
        
        return res;
    }
};