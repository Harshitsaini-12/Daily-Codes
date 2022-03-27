// { Driver Code Starts
//Initial Template for Java

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
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        	int [][]dp=new int[s1.length()+1][s2.length()+1];
		int max=0;

		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				char ch1=s1.charAt(i-1);
				char ch2=s2.charAt(j-1);

				if(ch1!=ch2){
					dp[i][j]=0;
				}else{
					dp[i][j]=dp[i-1][j-1]+1;
				}
				
				if(dp[i][j]>max){
				max=dp[i][j];
			}
			}
			
		}
		
		return max;
    }
}