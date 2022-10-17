class Solution {
public:
    bool checkIfPangram(string sentence) {
        unordered_map<char,int>hm;
        for(int i=0;i<sentence.length();i++){
            hm[sentence[i]]++;
        }
        
        if(hm.size()==26)return true;
        else return false;
    }
};