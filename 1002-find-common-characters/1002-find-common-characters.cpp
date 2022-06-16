class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        vector<int>hm1(26,0);
        vector<int>hm2(26,0);
        
        for(auto x:words[0]){
            hm1[x-'a']++;
        }
        
        for(int i=1;i<words.size();i++){
            for(char ch:words[i]){
                hm2[ch-'a']++;
            }
            
            for(int i=0;i<26;i++){
                hm1[i]=min(hm1[i],hm2[i]);
                hm2[i]=0;
            }
        }
            
        vector<string>ans;
        
        for(int i=0;i<26;i++){
            if(hm1[i]>0){
                int count=hm1[i];
                while(count-->0){
                    char x = i+ 'a';
					string s ;
					s = x;
					ans.push_back(s);
                }
            }
        }
        
        return ans;
    }
};