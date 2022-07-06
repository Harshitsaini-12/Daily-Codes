class Solution {
public:
    string reverseWords(string s) {
        reverse(s.begin(),s.end());
        
        int l=0;
        int r=0;
        int n=s.size();
        int i=0;
        
        while(i<n){
            
            while(i<n && s[i]!=' '){
                s[r++]=s[i++];
            }
            
            if(l<r){
                reverse(s.begin()+l , s.begin()+r);
                
                if(r==n)break;
                
                s[r++]=' ';
                l=r;
            }
            
            i++;
        }
        
        if(r>0 && s[r-1]==' ')r--;
        
        s.resize(r);
        
        return s;
    }
};