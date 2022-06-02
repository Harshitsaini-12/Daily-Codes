// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int p[] = new int[n];
            for(int i = 0;i < n;i++)
                p[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixChainOrder(p, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
        static String mcm_dp(int arr[],int SI,int EI,String[][]sdp,int[][]dp,int N){
       
        
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
        
        return sdp[SI][EI];
        
    }
    
    static String matrixChainOrder(int arr[], int N){
        // code here
        String sdp[][]=new String[N][N];
        int[][]dp=new int[N][N];
        mcm_dp(arr,0,N-1,sdp,dp,N);
        
        return sdp[0][N-1];
    }
}