// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n=nums.length;
        int[]LIS=new int[n];
        int[]LDS=new int[n];
        
        LIS_(nums,LIS);
        LDS_(nums,LDS);
        
        int maxlen=0;
        
        for(int i=0;i<n;i++){
            maxlen=Math.max(maxlen,LIS[i]+LDS[i]-1);
        }
        
        return maxlen;
        
    }
    
    public int LIS_(int[]nums,int []dp){
        int maxlen=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        
        return maxlen;
    }
    
    public int LDS_(int[]nums,int []dp){
        int maxlen=0;
        int n=nums.length;
        
        for(int i=n-1;i>=0;i--){
             dp[i]=1;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        
        return maxlen;
    }
    
    
}