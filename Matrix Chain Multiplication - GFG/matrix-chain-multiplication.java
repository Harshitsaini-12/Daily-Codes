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
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][]dp=new int[arr.length-1][arr.length-1];

		for(int gap=0;gap<dp.length;gap++){
			for(int i=0,j=gap;j<dp.length;j++,i++){
				if(gap==0){
					dp[i][j]=0;
				}else if(gap==1){
					dp[i][j]=arr[i]*arr[j]*arr[j+1];
				}else{
					int min=Integer.MAX_VALUE;

					for(int k=i;k<j;k++){
						//i to k left half & k+1 to j right half
						//left value=i*k+1 & right value=k+1*j+1

					    int lc=dp[i][k];
					    int rc=dp[k+1][j];
					    int mc=arr[i]*arr[k+1]*arr[j+1];

						int tc=lc+rc+mc;

						min=Math.min(min,tc);
					}
					
					dp[i][j]=min;
				}
			}
		}


		return dp[0][dp.length-1];
    }
}