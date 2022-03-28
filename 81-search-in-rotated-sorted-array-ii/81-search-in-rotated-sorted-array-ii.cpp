class Solution {
public:
    bool search(vector<int>& arr, int target) {
        int lo=0;
        int hi=arr.size()-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
             if(arr[mid]==target){
                return true;
            }
            
            if(arr[lo]==arr[mid] && arr[mid]==arr[hi]){
                lo++;
                hi--;
                continue;
                
            }else if(arr[lo]<=arr[mid]){
                if(arr[lo]<=target && target<=arr[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else if(arr[mid]<=arr[hi]){
                if(target>=arr[mid] && target<=arr[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }
        
        return false;
    }
};