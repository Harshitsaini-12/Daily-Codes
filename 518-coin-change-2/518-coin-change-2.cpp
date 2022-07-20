class Solution {
public:
    int change(int tar, vector<int>& arr) {
       int n=arr.size();

        vector<int>prev(tar+1,0),curr(tar+1,0);
  
        for(int T=0;T<=tar;T++){
            prev[T]=(T%arr[0]==0);
        }
        
        for(int idx=1;idx<n;idx++){
            for(int T=0;T<=tar;T++){
                int notTake=prev[T];
                
                int take=0;
                if(arr[idx]<=T){
                    take = curr[T-arr[idx]];
                }
                
                curr[T]=take + notTake;
            }
            prev=curr;
        }
        
        return prev[tar];
    }
};

