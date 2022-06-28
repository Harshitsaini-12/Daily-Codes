class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int p=1;
        int right[nums.size()];
        
        for(int i=nums.size()-1;i>=0;i--){
            p*=nums[i];
            right[i]=p;
        }
        
        p=1;
        int res[nums.size()];
        
        for(int i=0;i<nums.size()-1;i++){
            int lp=p;
            int rp=right[i+1];
            
            res[i]=lp*rp;
            p*=nums[i];
        }
        
        res[nums.size()-1]=p;
        
        vector<int>ans;
        for(int i=0;i<nums.size();i++){
            ans.push_back(res[i]);
        }
        
        return ans;
    }
};