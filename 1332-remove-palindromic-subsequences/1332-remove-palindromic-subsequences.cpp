class Solution {
public:
    int removePalindromeSub(string s) {
        if(s=="")return 0;
        string r=s;
        reverse(r.begin(),r.end());
        
        if(r==s){
            return 1;
        }
        else{
            return 2;
        }
    }
};