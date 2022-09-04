class Solution {
public:
    
    bool isPalin(string &s){
        int i=0;
        int j=s.size()-1;
        
        while(i<=j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    bool isStrictlyPalindromic(int n) {
//        for(int i=2;i<=n-2;i++){
//            string s;
//            int x=n;
           
//            while(x!=0){
//                s.push_back(x%i);
//                x/=i;
//            }
           
//            if(!isPalin(s)){
//                return false;
//            }
//        }
        
//         return true;
//     }
  return false;
    }
};