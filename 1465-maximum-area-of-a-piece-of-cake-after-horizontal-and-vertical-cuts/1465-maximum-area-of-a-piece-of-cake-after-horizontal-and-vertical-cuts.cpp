class Solution {
public:
    long maxDiff(int h,vector<int>v){
        
        sort(v.begin(),v.end());
        
        int maxelem=v[0];
        
        for(int i=1;i<v.size();i++){
            maxelem=max(maxelem,v[i]-v[i-1]);
        }
        
        maxelem=max(maxelem,h-v.back());
        return maxelem;
    }
    
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        long x=maxDiff(h,horizontalCuts);
        long y=maxDiff(w,verticalCuts);
        
        return (x*y)%(int)(1e9+7);
    }
};