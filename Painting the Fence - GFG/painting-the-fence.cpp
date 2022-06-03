// { Driver Code Starts
#include <bits/stdc++.h>
#include<stdio.h>
#include<math.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    typedef long long LL;
LL countWays(int n, int k){
    if (n == 1) return k;
    const LL MOD = 1e9+7;
    LL pp = 1, p = k;
    for (int i = 3; i <= n; i++) {
        LL c = (pp + p) * (k - 1) % MOD;
        pp = p; p = c;
    }
    return p * k % MOD;
}
};

// { Driver Code Starts.

int main()
{
	
	int t;
	cin>>t;
	while(t--)
	{
		int n,k;
		cin>>n>>k;
		Solution ob;
		cout<<ob.countWays(n,k)<<endl;
	}
	return 0;
}  // } Driver Code Ends