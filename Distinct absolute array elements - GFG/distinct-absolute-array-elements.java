// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int count=0;
        int next=Integer.MIN_VALUE;
        int prev=Integer.MIN_VALUE;
        
        int i=0;
        int j=n-1;
        
        while(i<=j){
            if(Math.abs(arr[i])==Math.abs(arr[j])){
                if(next!=arr[j] && prev!=arr[i])count++;
                
                prev=arr[i];
                next=arr[j];
                i++;
                j--;
            }else if(Math.abs(arr[i])<Math.abs(arr[j])){
                if(next!=arr[j])count++;
                
                next=arr[j];
                j--;
            }else{
                if(prev!=arr[i])count++;
                
                prev=arr[i];
                i++;
            }
        }
        return count;
    }
}
