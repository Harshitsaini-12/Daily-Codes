// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static int mcm_dp(int arr[],int SI,int EI,int[][]dp,int N){
        String sdp[][]=new String[N][N];
        
       for(int gap=1;gap<N;gap++){
           for(int si=0,ei=gap;ei<N;si++,ei++){
               if(ei-si==1){
                   dp[si][ei]=0;
                   sdp[si][ei]=(char)(si+'A')+"";
                   continue;
               }
               
               int minRes=(int)(1e9);
               String minStr="";
               
               for(int cut=si+1;cut<ei;cut++){
                   int leftRes=dp[si][cut];
                   int rightRes=dp[cut][ei];
                   
                   if(leftRes+rightRes+arr[si]*arr[cut]*arr[ei]<minRes){
                       minRes=leftRes+rightRes+arr[si]*arr[cut]*arr[ei];
                       minStr="(" + sdp[si][cut] + sdp[cut][ei] + ")";
                   }
               }
               
               dp[si][ei]=minRes;
               sdp[si][ei]=minStr;
           }
       }
        
        //  System.out.println(sdp[SI][EI]);
        return dp[SI][EI];
        
    }
    
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][]dp=new int[N][N];
        return mcm_dp(arr,0,N-1,dp,N);
    }
}