// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
          BigInteger a[] = new BigInteger[n+1];
       a[0]=BigInteger.valueOf(1);
       a[1]=BigInteger.valueOf(1);
       for(int i=2;i<=n;i++){
           a[i]=BigInteger.valueOf(0);
           for(int j=0;j<i;j++){
               a[i]=(a[i].add(a[j].multiply(a[i-j-1])));
           }
       }
       return a[n];
       
   }
}