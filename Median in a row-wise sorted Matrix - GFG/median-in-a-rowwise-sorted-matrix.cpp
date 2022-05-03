// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
int getSmallerElement(vector<int>&row,int mid){
    int l=0;
    int h=row.size()-1;
    
    while(l<=h){
        int md=(l+h)>>1;
        
        if(row[md]<=mid)l=md+1;
        else h=md-1;
    }
    return l;
}
    

    int median(vector<vector<int>> &A, int r, int c){
        // code here    
        
        int low=1;
        int high=1e9;
        int m=A.size();
        int n=A[0].size();
        
        while(low<=high){
            int mid=(low+high)>>1;
            int count=0;
            
            for(int i=0;i<m;i++){
                count+=getSmallerElement(A[i],mid);
            }
            
            if(count<=(n*m)/2)low=mid+1;
            else high=mid-1;
        }
        
        return low;
    }
};

// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int r, c;
        cin>>r>>c;
        vector<vector<int>> matrix(r, vector<int>(c));
        for(int i = 0; i < r; ++i)
            for(int j = 0;j < c; ++j)
                cin>>matrix[i][j];
        Solution obj;
        cout<<obj.median(matrix, r, c)<<endl;        
    }
    return 0;
}  // } Driver Code Ends