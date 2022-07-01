class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        
        unordered_map<int,int>hm;
        
        int presum=0;
        int n=nums.size();
        int ans=0;
        
        hm[presum]=-1;
        
        for(int i=0;i<n;i++){
            int val=nums[i];
            
            if(val==0){
                presum-=1;
            }else{
                presum+=1;
            }
            
            if(hm.find(presum)!=hm.end()){
                int len=i-hm[presum];
                ans=max(ans,len);
            }else{
                hm[presum]=i;
            }
        }
        
        return ans;
    }
};