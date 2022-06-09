class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int>ans(2);
        
      int i=0;
      int j=nums.size()-1;
        
        while(i<j){
            int sum=nums[i]+nums[j];
            
            if(sum==target){
                ans[0]=i+1;
                ans[1]=j+1;
                break;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return ans;
//         unordered_map<int,int>hm;
        
//         for(int i=0;i<nums.size();i++){
//             if(hm.find(target-nums[i])!=hm.end()){
//                 ans[0]=(hm[target-nums[i]]+1);
//                 ans[1]=(i+1);
//             }
//             hm[nums[i]]=i;
//         }

        return ans;
    }
};