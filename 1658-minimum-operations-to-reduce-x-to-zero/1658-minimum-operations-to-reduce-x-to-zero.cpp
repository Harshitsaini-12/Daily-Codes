class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int sum=0;
        int n=nums.size();
   
        int i=0;
        for(int val:nums)sum+=val;
        int target=sum-x;
        int curr_sum=0;
        
        bool found=false;
        int len=0;
        
        for(int j=0;j<n;j++){
            curr_sum+=nums[j];
            
            while(i<=j && curr_sum>target){
                curr_sum-=nums[i];
                i++;
            }
            
            if(curr_sum==target){
                found=true;
                len=max(len,j-i+1);
            }
        }
        
        return found==true ? (n-len) : -1;
    }
};