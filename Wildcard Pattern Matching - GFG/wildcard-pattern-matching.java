// { Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}// } Driver Code Ends


class Solution
{
    int wildCard(String p, String s)
    {
        // Your code goes here
        p=removeStar(p);
        int n=s.length();
        int m=p.length();
        
        int[][]dp=new int[n+1][m+1];
        
        for(int[]d:dp)Arrays.fill(d,-1);
        
       int ans=memo(s,p,n,m,dp);
        return ans;
    }
    public int memo(String s,String p,int n,int m,int[][]dp){
        if(n==0 || m==0){
            if(n==0 && m==0)return dp[n][m]=1;//true
            else if(m==1 && p.charAt(m-1)=='*'){
                return dp[n][m]=1;
            }else{
                return dp[n][m]=0;
            }
        }
        
        if(dp[n][m]!=-1)return dp[n][m];
        
        char ch1=s.charAt(n-1);
        char ch2=p.charAt(m-1);
        
        if(ch1==ch2 || ch2=='?'){
            return dp[n][m]=memo(s,p,n-1,m-1,dp);
        }else if(ch2=='*'){
            
            boolean res=false;
            
            res=res || memo(s,p,n-1,m,dp)==1; //if it is including as a sequence
            res=res || memo(s,p,n,m-1,dp)==1; //if treated as a empty sequence
            
            return dp[n][m]= res ? 1 : 0;
            
        }else{
            return dp[n][m]=0;
        }
    
    }
    
    public String removeStar(String s){
        StringBuilder sb=new StringBuilder();
        
        if(s.length()==0)return s;
        sb.append(s.charAt(0));
        
        int i=1;
        
        while(i<s.length()){
            while(i<s.length() && sb.charAt(sb.length()-1)=='*' && s.charAt(i)=='*')i++;
            
            if(i<s.length())sb.append(s.charAt(i));
            i++;
        }
        
        return sb.toString();
    }
}
