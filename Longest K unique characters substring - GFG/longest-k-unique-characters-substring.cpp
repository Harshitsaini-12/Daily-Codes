// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
    int longestKSubstr(string s, int k) {
    // your code here
        int n=s.size();

        int si=0;
        int ei=0;
        int count=0;
        int len=-1;
        int so=0;
        vector<int>freq(128);

        while(ei<n){
            if(freq[s[ei]]==0){
                count++;
            }

            freq[s[ei]]++;
            ei++;

            while(count>k){
                if(freq[s[si]]==1){
                    count--;
                }
                freq[s[si]]--;
                si++;
            }

            if(count==k){
                len=max(len,ei-si);
                // so=si;
            }
        }

        // cout<<s.substr(so,len)<<endl;
        return len;
      
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int k;
        cin >> k;
        Solution ob;
        cout << ob.longestKSubstr(s, k) << endl;
    }
}
  // } Driver Code Ends