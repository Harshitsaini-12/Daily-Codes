// { Driver Code Starts
#include<iostream>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    int isPowerOfFour(unsigned int n)
    {
      // Your code goes here
      	int c=1;
     while(n>0)
     {
         ++c;
         if((n&1)==1&&n!=1)
         return 0;
         
         n=n>>1;
         
     }
     if(c%2==0)
     return 1;
     else return 0;
      
    }
};

// { Driver Code Starts.

/*Driver program to test above function*/
int main()
{
int t,n;
cin>>t;
while(t--)
{
cin>>n;
Solution ob;
if(ob.isPowerOfFour(n))
	cout<<1<<endl;
else
	cout<<0<<endl;
}
//getchar();
}
  // } Driver Code Ends