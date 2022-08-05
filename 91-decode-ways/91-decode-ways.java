class Solution {
    public int decoding(String s,int idx,int[]dp){
       if(idx==s.length())return 1;
        
       if(dp[idx]!=-1)return dp[idx];
        
        char ch=s.charAt(idx);
        if(ch=='0')return 0;
        
        int count=0;
        count+=decoding(s,idx+1,dp);
        
        if(idx<s.length()-1){
            char ch2=s.charAt(idx+1);
            int val=(ch-'0')*10 + (ch2-'0');
            
            if(val<=26){
                count+=decoding(s,idx+2,dp);
            }
        }
        
        return dp[idx]=count;
        
    }
    
    public int numDecodings(String s) {
        int n=s.length();
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return decoding(s,0,dp);
    }
}