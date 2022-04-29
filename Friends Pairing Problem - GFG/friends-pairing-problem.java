// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
       int mod = (int) 1e9 + 7;
    public long memo(int n,long[]dp){
        if(n<=1){
            dp[n]=1;
        }
        
        if(dp[n]!=0)return dp[n];
        
        long single=memo(n-1,dp)%mod;
        long pair=memo(n-2,dp)*(n-1)%mod;
        
        return dp[n]=(single+pair)%mod;
    }
    
    public long countFriendsPairings(int n) 
    { 
       //code here
    
       long arr[]=new long[n+1];
       long ans=memo(n,arr);
       return ans%mod;
    }
}    
 