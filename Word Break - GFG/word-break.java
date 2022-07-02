// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String s, ArrayList<String> B )
    {
        //code here
         HashSet<String>set=new HashSet<>();
        
        int maxlen=0;
        
        for(String ss:B){
            set.add(ss);
            maxlen=Math.max(maxlen,ss.length());
        }
        
        int n=s.length();
        
        boolean[]dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=0;i<=n;i++){
            if(!dp[i])continue;
            
            for(int l=1;l<=maxlen && i+l<=n;l++){
                String substr=s.substring(i,i+l);
                
                if(set.contains(substr)){
                    dp[i+l]=true;
                }
            }
        }
        
        return dp[n]?1:0;
    }
}