class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        vector<vector<int>>res;
        
        int n=nums.size();
        if(n==0)return res;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                
                int ntar=target-nums[i]-nums[j];
                
                int left=j+1;
                int right=n-1;
                
                while(left<right){
                    
                    if(nums[left]+nums[right]==ntar){
                        
                        vector<int>ans(4,0);
                        ans[0]=nums[i];
                        ans[1]=nums[j];
                        ans[2]=nums[left];
                        ans[3]=nums[right];
                        
                        res.push_back(ans);
                        
                        while(left<right && nums[left]==ans[2])left++;
                               
                        while(left<right && nums[right]==ans[3])right--;
                        
                    }else if(nums[left]+nums[right]<ntar){
                        left++;
                    }else{
                        right--;
                    }
                }
                
                while(j+1<n && nums[j]==nums[j+1])j++;
            }
            
            while(i+1<n && nums[i]==nums[i+1])i++;
        }
        
        return res;
    }
};