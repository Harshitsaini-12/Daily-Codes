// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int kadane(int[]arr){
        int sum=0;
        int msum=-(int)(1e9);
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
              msum=Math.max(msum,sum);
            if(sum<0){
                sum=0;
            }
            
          
        }
        return msum;
    }
    
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int ans=-(int)(1e9);
        for(int fixed_row=0;fixed_row<R;fixed_row++){
            int []prearray=new int[C];
            
            for(int row=fixed_row;row<R;row++){
                for(int col=0;col<C;col++){
                    prearray[col] = prearray[col] + M[row][col];
                }
                
                int sum=kadane(prearray);
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
};