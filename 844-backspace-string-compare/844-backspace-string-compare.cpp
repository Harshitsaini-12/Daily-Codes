class Solution {

    string reduce(string s){
        int n=s.length();
        int i=n-1;
        int backspace=0;
        string res="";
        
        while(i>=0){
            if(s[i]=='#'){
                backspace++;
            }else{
                if(backspace==0){
                    res+=s[i];
                }else if(backspace>0){
                    backspace--;
                }
            }
            i--;
        }
        
        return res;
    }
    
public:
    bool backspaceCompare(string s, string t) {
        string a=reduce(s);
        string b=reduce(t);
        
       return a==b;
    }
};