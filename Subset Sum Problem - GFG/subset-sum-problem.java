// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static int subsetSum(int[]arr,int n,int tar,int[][]dp){
        if(tar==0 || n==0){
            return dp[n][tar]= (tar==0?1:0);
        }
        
        if(dp[n][tar]!=-1)return dp[n][tar];
        
        boolean res=false;
        
        if(tar-arr[n-1]>=0){
            res=res || subsetSum(arr,n-1,tar-arr[n-1],dp)==1;
            
        }
        
        res=res || subsetSum(arr,n-1,tar,dp)==1;
        
        return dp[n][tar] = res ? 1 : 0 ;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][]dp=new int[N+1][sum+1];
        
        for(int[]d:dp)Arrays.fill(d,-1);
        
        return subsetSum(arr,N,sum,dp)==1?true:false;
    }
}