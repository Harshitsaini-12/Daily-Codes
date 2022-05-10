// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int nums[], int n)
    {
        int[]LIS=new int[n];
        int[]LDS=new int[n];
        
        LIS_(nums,LIS);
        LDS_(nums,LDS);
        
        int maxsum=0;
        
        for(int i=0;i<n;i++){
            maxsum=Math.max(maxsum,LIS[i]+LDS[i]-nums[i]);
        }
        
        return maxsum;
    }
    
    public static int LIS_(int[]nums,int []dp){
        int maxlen=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            dp[i]=nums[i];
            for(int j=i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+nums[i],dp[i]);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        
        return maxlen;
    }
    
    public static int LDS_(int[]nums,int []dp){
        int maxlen=0;
        int n=nums.length;
        
        for(int i=n-1;i>=0;i--){
             dp[i]=nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+nums[i],dp[i]);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        
        return maxlen;
    }
}