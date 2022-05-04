class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int count=0;
        
        unordered_map<int,int>hm;

        for(int i=0;i<nums.size();i++){
            if(hm[k-nums[i]]>0){
                count++;
                hm[k-nums[i]]--;
            }else{
                hm[nums[i]]++;
            }
        }
        
        return count;
    }
};