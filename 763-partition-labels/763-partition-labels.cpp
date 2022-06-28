class Solution {
public:
    vector<int> partitionLabels(string s) {
        unordered_map<char,int>hm;
        
        for(int i=0;i<s.length();i++){
            hm[s[i]]=i;
        }
        
        vector<int>ans;
        
        int prev=-1;
        int maxi=INT_MIN;
        
        for(int i=0;i<s.length();i++){
            maxi=max(maxi,hm[s[i]]);
            
            if(maxi==i){
                ans.push_back(maxi-prev);
                prev=maxi;
            }
        }
        
        return ans;
    }
};