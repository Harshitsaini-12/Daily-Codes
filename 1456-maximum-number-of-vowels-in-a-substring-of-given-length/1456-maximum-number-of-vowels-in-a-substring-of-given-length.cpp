class Solution {
public:
    int maxVowels(string s, int k) {
        int n=s.size();
        vector<int>freq(128);
        
        int si=0;
        int ei=0;
        int count=0;
        
      while(ei<k){
          
           if(isVowel(s[ei])){
                count++;
           }
          
          freq[s[ei]]++;
          ei++;
      }
        
        int ans=count;
        
        while(ei<n){
            ans=max(ans,count);
            
            if(isVowel(s[ei])){
                count++;
            }
            freq[s[ei]]++;
            ei++;
            
            if(isVowel(s[si])){
                count--;
            }
            freq[s[si]]--;
            si++;
        }
        
        ans=max(ans,count);
        return ans;
    }
    
    bool isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')return true;
        else return false;
    }
};