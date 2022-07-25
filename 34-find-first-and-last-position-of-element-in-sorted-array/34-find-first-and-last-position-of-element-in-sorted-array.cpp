class Solution {
public:
    
    
int firstIndex( vector<int>& nums,int target) {
        int ans = -1;
        
        int strt = 0;
        int end = nums.size()-1;
        int mid;
        
        while(strt<= end){
            mid = strt + (end-strt)/2;
            
            if(nums[mid] == target) ans = mid;
            
            if(nums[mid] >= target) end = mid-1;
            
            else strt = strt+1;
            
        }
        
        return ans;
}
    
 int lastIndex(vector<int>& nums,int target) {
    int ans  = -1;
        int strt = 0;
        int end = nums.size()-1;
        int mid;
        
        while(strt <= end){
            mid = strt + (end-strt)/2;
            
            if(nums[mid] == target) ans = mid;
            
            if(nums[mid]>target) end = mid-1;
            else strt = mid +1;
        }
        
        return ans;

}
    
    vector<int> searchRange(vector<int>& nums, int target) {

        
        int n=firstIndex(nums,target);
        int m=lastIndex(nums,target);
        
         return {n,m};
    }
};