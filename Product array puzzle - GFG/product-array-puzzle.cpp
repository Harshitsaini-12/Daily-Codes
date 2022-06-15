// { Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
    // nums: given vector
    // return the Product vector P that hold product except self at each index
    vector<long long int> productExceptSelf(vector<long long int>& nums, int n) {
       
        //code here    
  vector<long long> v;
       long long prod=1;
       int zero=0;
       for(int i=0; i<n; i++){
           if(nums[i]==0){zero++;continue;}
           else prod*=nums[i];
       }
       if(zero>1){
           for(int i=0; i<n; i++)
           v.push_back(0);
       }
       else if(zero==1){
           for(int i=0; i<n; i++){
               if(nums[i]!=0)
               v.push_back(0);
               else v.push_back(prod);
           }
       }
       else{
           for(int i=0; i<n; i++)
           v.push_back(prod/nums[i]);
       }
       return v;
    }
};


// { Driver Code Starts.
int main()
 {
    int t;  // number of test cases
    cin>>t;
    while(t--)
    {
        int n;  // size of the array
        cin>>n;
        vector<long long int> arr(n),vec(n);
        
        for(int i=0;i<n;i++)    // input the array
        {
            cin>>arr[i];
        }
        Solution obj;
        vec = obj.productExceptSelf(arr,n);   // function call
        
        for(int i=0;i<n;i++)    // print the output
        {
            cout << vec[i] << " ";
        }
        cout<<endl;
    }
	return 0;
}  // } Driver Code Ends