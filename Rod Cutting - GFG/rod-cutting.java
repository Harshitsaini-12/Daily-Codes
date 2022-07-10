// { Driver Code Starts

import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.cutRod(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int[][]memo=new int[n+1][n+1];
        
        return ans(price,0,n,memo);
    }
    
    public int ans(int price[],int ci,int n,int[][]memo){
        if(n==0)return 0;
        
        if(ci>=n)return 0;
        
        if(memo[ci][n]!=0)return memo[ci][n];
        
        int Consider=0;
        if(ci+1<=n){
            Consider=price[ci] + ans(price,ci,n-(ci+1),memo);
        }
        
        int notConsider=ans(price,ci+1,n,memo);
        
        memo[ci][n]=Math.max(Consider,notConsider);
        return memo[ci][n];
    }
}