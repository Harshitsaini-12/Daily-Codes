class Solution {
    public boolean isMatch(String s, String p) {
        
        p=removestar(p);
        int n=s.length();
        int m=p.length();
        
        int[][]dp=new int[n+1][m+1];
        for(int[]d:dp)Arrays.fill(d,-1);
        
        int ans=isMatch_(s,p,dp,n,m);
        return ans==1;
    }
    
    public int isMatch_(String s,String p,int[][]dp,int n,int m){
        
        if(n==0 || m==0){
            if(n==0 && m==0)return dp[n][m]=1;
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
            return isMatch_(s,p,dp,n-1,m-1);
        }else if(ch2=='*'){
            boolean ans=false;
            
            ans=ans || isMatch_(s,p,dp,n-1,m)==1;// if taken into consdireation into sequence
            ans=ans || isMatch_(s,p,dp,n,m-1)==1;// if not taken into sequence
            
            return dp[n][m]=ans?1:0;
            
        }else{
            return dp[n][m]=0; 
        }
    }
    
    public String removestar(String p){
        
        StringBuilder sb=new StringBuilder();
         if(p.length()==0)return p;
        
        int i=1;
        sb.append(p.charAt(0));
        
        while(i<p.length()){
            
            while(i<p.length() && sb.charAt(sb.length()-1)=='*' && p.charAt(i)=='*')i++;
            
            if(p.length()>i)sb.append(p.charAt(i));
            
            i++;
        }
        
        return sb.toString();
    }
}