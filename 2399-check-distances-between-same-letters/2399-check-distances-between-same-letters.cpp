class Solution {
public:
    bool checkDistances(string s, vector<int>& distance) {
        unordered_map<int,int>hm;
        
        for(int i=0;i<s.size();i++){
            if(hm[s[i]]==0){
                hm[s[i]]=i+1;
            }else{
                if(distance[s[i]-'a']!=i-hm[s[i]]){
                    return false;
                }
            }
        }
        
        return true;
    }
};