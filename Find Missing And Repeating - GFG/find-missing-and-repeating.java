// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int []ans=new int[2];
        int xor=0;
        for(int val:arr){
            xor^=val;
        }
        
        for(int i=1;i<=n;i++)xor^=i;
        
        int rsb=xor&(-xor);
        int a=0;
        int b=0;
        
        for(int val:arr){
            if((val&rsb)==0){
                a^=val;
            }else{
                b^=val;
            }
        }
        
        for(int i=1;i<=n;i++){
            if((i&rsb)==0){
                a^=i;
            }else{
                b^=i;
            }
        }
        
        for(int val:arr){
            if(val==a){
                ans[0]=a;
                ans[1]=b;
                break;
            }else if(val==b){
                ans[0]=b;
                ans[1]=a;
                break;
            }
        }
        
        return ans;
    }
}