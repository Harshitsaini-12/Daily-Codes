class Solution {
public:
    int minMoves2(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        
        int i=0;
        int count=0;
        int j=nums.size()-1;
        
        while(i<=j){
            count+=nums[j]-nums[i];
            i++;
            j--;
        }
        
        return count;
    }
};