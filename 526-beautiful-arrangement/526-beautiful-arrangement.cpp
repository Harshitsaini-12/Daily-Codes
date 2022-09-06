class Solution {
public:
    int countArrangement(int n) {
        vector<int>v;
        for(int i=1;i<=n;i++)v.push_back(i);
        
        return permutute(v,n);
    }
    
    int permutute(vector<int>&v,int n){
        
        if(n<=0)return 1;
        
        int count=0;
        for(int i=0;i<n;i++){
            if(v[i]%n==0 || n%v[i]==0){
                swap(v[i],v[n-1]);
                count+=permutute(v,n-1);
                swap(v[i],v[n-1]);
            }
        }
        return count;
    }
};