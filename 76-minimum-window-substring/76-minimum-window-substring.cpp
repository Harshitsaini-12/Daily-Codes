class Solution {
public:
    string minWindow(string s, string t) {
        int n=s.size();
        int si=0;
        int ei=0;
        
        int so=0;
        int len=(int)1e9;
        int need=0;
        
        vector<int>freq(128);
        
        for(int i=0;i<t.size();i++){
            freq[t[i]]++;
            need++;
        }
        
        while(ei<n){
            if(freq[s[ei]]>0){
                need--;
            }
     
            freq[s[ei]]--;
            ei++;
            
            while(need==0){
                 if(ei-si<len){
                    len=ei-si;
                    so=si;
                }
                
                if(freq[s[si]]==0){
                    need++;
                }
           
                freq[s[si]]++;
                si++;
            }
        }
        
        return len == (int)1e9 ? "" : s.substr(so,len);
    }
};