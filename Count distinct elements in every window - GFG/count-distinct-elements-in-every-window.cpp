// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends

class Solution{
  public:
    vector <int> countDistinct (int arr[], int n, int k)
    {
        //code here.
        vector<int>ans;
        unordered_map<int,int>hm;
        int de=0;
        
        for(int i=0;i<k-1;i++){
            int val=arr[i];
            
            if(hm.find(val)!=hm.end()){
                 hm[val]++;
            }else{
                 hm[val]=1;
                 de++;
            }
        }
        
        int release=0;
        
        for(int i=k-1;i<n;i++){
            int val=arr[i];
            
            if(hm.find(val)!=hm.end()){
                 hm[val]++;
            }else{
                  hm[val]=1;
                  de++;
            }
            
            ans.push_back(de);
            int deletevalue=arr[release];
            hm[deletevalue]--;
            
            if(hm[deletevalue]==0){
                hm.erase(deletevalue);
                de--;
            }
            release++;
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

        int n, k;
        cin >> n >> k;
        int a[n];
        for (int i = 0; i < n; i++) 
        	cin >> a[i];
        Solution obj;
        vector <int> result = obj.countDistinct(a, n, k);
        for (int i : result) 
        	cout << i << " ";
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends