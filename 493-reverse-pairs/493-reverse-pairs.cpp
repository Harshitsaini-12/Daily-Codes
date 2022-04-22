class Solution {
public:
    
    int merge(vector<int>&nums,int low,int mid,int high){
        int count=0;
        int j=mid+1;
        
        for(int i=low;i<=mid;i++){
            while(j<=high && 2LL*nums[j]<nums[i]){
                j++;
            }
            count+=(j-(mid+1));
        }
        
        vector<int>temp;
        int left=low;
        int right=mid+1;
        
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.push_back(nums[left++]);
            }else{
                temp.push_back(nums[right++]);
            }
        }
        
        while(left<=mid){
             temp.push_back(nums[left++]);
        }
        
        while(right<=high){
             temp.push_back(nums[right++]);
        }
        
        for(int i=low;i<=high;i++){
            nums[i]=temp[i-low];
        }
        
        return count;
    }
    
    int mergeSort(vector<int>&nums,int start,int end){
        if(start>=end)return 0;
        
        int mid=(start+end)/2;
        
        int inv=mergeSort(nums,start,mid);
        inv+=mergeSort(nums,mid+1,end);
        
        inv+=merge(nums,start,mid,end);
        return inv;
    }
    
    int reversePairs(vector<int>& nums) {
        return mergeSort(nums,0,nums.size()-1);
    }
};