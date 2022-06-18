class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int right_sum=0;
        int left_sum=0;
        
        for(int i=0;i<nums.size();i++){
            right_sum+=nums[i];
        }
        
        for(int j=0;j<nums.size();j++){
            
            right_sum-=nums[j];
            
            if(left_sum==right_sum)return j;
            
            left_sum+=nums[j];
        }
        return -1;
    }
};