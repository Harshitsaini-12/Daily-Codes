class Solution {
public:
    int numberarray(vector<int>&nums,int k){
        int si=0;
        int ei=0;
        int n=nums.size();
        
        int count=0;
        int ans=0;
        
        //acquire
        while(ei<n){
            if(nums[ei]%2!=0){
                count++;
            }
            
            ei++;
            
            //release
            while(count>k){
                if(nums[si]%2!=0){
                    count--;
                }
                
                si++;
            }
            ans+=(ei-si+1);
        }
        
        return ans;
    }
    
    int numberOfSubarrays(vector<int>& nums, int k) {
        //for exactly k non-distict no's
        return numberarray(nums,k)-numberarray(nums,k-1);
    }
};