class Solution {
public:
    void nextPermutation(vector<int>& nums) {
     int size=nums.size();
        int k;
        int l;
        
        for(k=size-2;k>=0;k--){
            if(nums[k]<nums[k+1]){
                break;
            }
        }
        
        
        if(k<0){
            reverse(nums.begin(),nums.end());
        }else{
            for(l=size-1;l>=0;l--){
                if(nums[l]>nums[k]){
                    break;
                }
            }

            swap(nums[l],nums[k]);
            reverse(nums.begin()+k+1,nums.end());
        }
    }
};

//tc 0(n)
//sc 0(n)