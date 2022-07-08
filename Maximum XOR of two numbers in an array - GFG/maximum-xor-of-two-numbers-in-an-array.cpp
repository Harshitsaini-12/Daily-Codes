// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
     class TrieNode{
      public:
        TrieNode*children[2];
        
        TrieNode(){
            children[0]=nullptr;
            children[1]=nullptr;
        }
    };
    int max_xor(int nums[] , int n)
    {
        //code here
        TrieNode* root=new TrieNode();
        
        //insert
        for(int i=0;i<n;i++){
            int elem=nums[i];
            TrieNode* curr=root;
            
            for(int i=31;i>=0;i--){
                int bit=(elem>>i & 1);
                
                if(curr->children[bit]==nullptr){
                    curr->children[bit]=new TrieNode();
                }
                
                curr=curr->children[bit];
            }
        }
        
        //calculating 
        int ans=0;
        for(int i=0;i<n;i++){
            int elem=nums[i];
             TrieNode* curr=root;
             int curr_ans=0;
            
            for(int i=31;i>=0;i--){
                int bit=(elem>>i & 1);
                
                int search_bit=bit==1?0:1;
                
                if(curr->children[search_bit]!=nullptr){
                    curr=curr->children[search_bit];
                    
                    curr_ans+=(int)pow(2,i);
                }else{
                     curr=curr->children[bit];
                }
            }
             
             ans=max(ans,curr_ans);
        }
        
      return ans;
    }
    
};


// { Driver Code Starts.
int main()
{
	int t;
	cin >> t;

	while (t--)
	{
		int n;
		cin >> n;

		int a[n];
		for (int i = 0; i < n; i++)
			cin >> a[i];

        Solution ob;
		cout << ob.max_xor(a, n) << endl;

	}
}


  // } Driver Code Ends