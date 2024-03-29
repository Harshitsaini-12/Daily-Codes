// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int validate(int[]arr){
        int val=arr[0];
        int count=1;
        
        for(int i=1;i<arr.length;i++){
            
            if(arr[i]==val){
                count++;
            }else{
                count--;
            }
            
            if(count==0){
                val=arr[i];
                count=1;
            }
        }
        
        return val;
        
    }
    static int majorityElement(int a[], int size)
    {
        // your code here
        int val=validate(a);
        int count=0;
        
        for(int i=0;i<size;i++){
            if(a[i]==val){
                count++;
            }
        }
        if(count>size/2){
            return val;
        }else{
            return -1;
        }
    }
}