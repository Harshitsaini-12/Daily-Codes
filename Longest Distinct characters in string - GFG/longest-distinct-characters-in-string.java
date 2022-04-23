// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String s){
        // code here
        int answer=0;
        int left=0;
        
        HashMap<Character,Integer>hm=new HashMap<>();
        
        for(int right=0;right<s.length();right++){
            Character curr=s.charAt(right);
            
            if(hm.containsKey(curr) && hm.get(curr)>= left){
                left=hm.get(curr)+1;
            }
            
            int a=right - left + 1;
            hm.put(curr,right);
            answer=Math.max(a,answer);
        }
        
        return answer;
    }
}