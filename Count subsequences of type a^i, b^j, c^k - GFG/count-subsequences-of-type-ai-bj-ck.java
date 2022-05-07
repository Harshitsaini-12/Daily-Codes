// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.next());
		
		while(t>0)
		{
		    String s = sc.next();
		    
		    Solution T = new Solution();
		    System.out.println(T.fun(s));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int fun(String s)
    {
        // Write your code here
        long MOD=1000000007;
        long acount=0,bcount=0,cCount=0;
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='a'){
               acount=(acount+(1+acount))%MOD;
            }else if(ch=='b'){
                bcount=(bcount+ (acount + bcount))%MOD;
            }else{
                cCount=(cCount+ (bcount + cCount))%MOD;
            }
        }
        return (int)(cCount%MOD);
    }
}