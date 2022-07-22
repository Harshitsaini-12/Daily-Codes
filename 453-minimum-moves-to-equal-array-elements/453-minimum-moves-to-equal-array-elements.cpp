class Solution {
public:
    int minMoves(vector<int>& nums) {
       int mini=INT_MAX;
       for(int num:nums)mini=min(mini,num);
        
       int count=0;
        
       for(int num:nums){
           count+=(num-mini);
       }
        
       return count;
    }
};