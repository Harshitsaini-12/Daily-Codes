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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public int minOperations_(String s1,String s2,int n,int m,int[][]dp){
        if(n==0 || m==0){
            return dp[n][m]=n==0?m:n;
        }
        
        if(dp[n][m]!=0){
            return dp[n][m];
        }
        
        int a=minOperations_(s1,s2,n,m-1,dp);
        int b=minOperations_(s1,s2,n-1,m,dp);
        int c=minOperations_(s1,s2,n-1,m-1,dp);
        
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=c;
        }else{
            return dp[n][m]=Math.min(a,b)+1;
        }
        
        
    }
    
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n=str1.length();
	    int m=str2.length();
	    
	    int[][]dp=new int[n+1][m+1];
	    
	    int ans=minOperations_(str1,str2,n,m,dp);
	    return ans;
	} 
}