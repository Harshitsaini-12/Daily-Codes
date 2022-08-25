class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int n=s1.size();
        int m=s2.size();
        
        int i=0,j=0;
        int total_char=s1.size();
        
        int arr[26]={0};
        
        for(char s:s1)arr[s-'a']++;
        
        while(j<m){
            if(arr[s2[j++]-'a']-->0){
                total_char--;
            }
            
            if(total_char==0)return true;
            
            if(j-i==n && arr[s2[i++]-'a']++ >= 0)total_char++;
        }
        
        return false;
    }
};