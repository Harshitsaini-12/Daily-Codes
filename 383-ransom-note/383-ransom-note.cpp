class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        
        int count[26]={0};
        
        for(auto c:magazine){
            count[c-'a']++;
        }
        
        for(auto s:ransomNote){
            
            if(count[s-'a']-- <=0){
                return false;
            }
        }
        return true;
    }
};