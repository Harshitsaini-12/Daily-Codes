// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] nums, int n) {
        // code here
        long ans=Long.MIN_VALUE;
        long cprod=1L;
        
        for(int i=0;i<nums.length;i++){
            cprod*=nums[i];
            
            ans=Math.max(ans,cprod);
            if(cprod==0){
                cprod=1;
            }
        }
        
        cprod=1;
        for(int i=nums.length-1;i>=0;i--){
             cprod*=nums[i];
            
            ans=Math.max(ans,cprod);
            if(cprod==0){
                cprod=1;
            }
        }
        
        return ans;
    }
}