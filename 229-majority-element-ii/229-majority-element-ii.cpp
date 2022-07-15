class Solution {
public:
    bool isgreater(int val,vector<int>&nums){
        int count=0;
        
        for(int i=0;i<nums.size();i++){
            if(nums[i]==val){
              count++;
            }
        }
        return count>nums.size()/3;
    }
    
    vector<int> majorityElement(vector<int>& nums) {
        vector<int>ans;
        int val1=nums[0];
        int count1=1;
        
        int val2=nums[0];
        int count2=0;
        
        int i=1;
        while(i<nums.size()){
            if(nums[i]==val1){
                count1++;
            }else if(nums[i]==val2){
                count2++;
            }else{
                if(count1==0){
                    val1=nums[i];
                    count1=1;
                }else if(count2==0){
                    val2=nums[i];
                    count2=1;
                }else{
                    count1--;
                    count2--;
                }
            }
            i++;
        }
        
        if(isgreater(val1,nums)){
            ans.push_back(val1);
        }
        
        //imp for similar elements
        if(val1!=val2 && isgreater(val2,nums)){
            ans.push_back(val2);
        }
        
        return ans;
    }
};