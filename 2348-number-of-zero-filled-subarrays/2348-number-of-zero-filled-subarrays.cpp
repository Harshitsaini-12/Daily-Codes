class Solution {
public:
    long long zeroFilledSubarray(vector<int>& arr) {
       long long res=0;
        int n=arr.size();
        long long count=0;
        
       for(int i=0;i<n;i++){
           if(arr[i]==0)count++;
           else{
               res+=(count*(count+1LL)/2);
               count=0;
           }
       }
        
        return res + (count*(count+1LL)/2);;
           
    }
};