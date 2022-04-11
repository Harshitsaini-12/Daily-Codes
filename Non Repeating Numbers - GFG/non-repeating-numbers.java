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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] arr)
    {
        // Code here
        int[]ans=new int[2];
          int res=0;
   
   for(int val:arr){
     res^=val;
   }
   

   int mask=(res&-res);
   int seta=0;
   int setb=0;

   for(int val:arr){
     if((val&mask)==0){
       seta^=val;
     }else{
       setb^=val;
     }
   }

   if(seta<setb){
     ans[0]=seta;
     ans[1]=setb;
   }else{
    ans[0]=setb;
     ans[1]=seta;
    
   }
   
   return ans;
    }
}