class Solution {
    int mod=(int)1e9+7;
    
    public long numDecodings_memo(String s,int idx,long[]dp){
        if(idx==s.length())return dp[idx]=1;
        
        if(dp[idx]!=-1)return dp[idx];
        
        if(s.charAt(idx)=='0'){
            return 0;
        }
        
        long count=0;
        char c1=s.charAt(idx);
        
        if(s.charAt(idx)=='*'){
             count=(count%mod  +  9*numDecodings_memo(s,idx+1,dp)%mod)%mod;
            
            if(idx<s.length()-1){
                 char ch=s.charAt(idx+1);
                
                if(ch=='*'){
                    count=(count%mod  +  15*numDecodings_memo(s,idx+2,dp)%mod)%mod;
                }else if(ch>='0' && ch<='6'){
                     count=(count%mod  +  2*numDecodings_memo(s,idx+2,dp)%mod)%mod;
                }else if(ch>'6'){
                    count=(count%mod  +  numDecodings_memo(s,idx+2,dp)%mod)%mod;
                }
                
            }
            
        }else{
            count=(count%mod  +  numDecodings_memo(s,idx+1,dp)%mod)%mod;
            
            if(idx<s.length()-1){
                if(s.charAt(idx+1)!='*'){
                    char ch2=s.charAt(idx+1);
                    
                    int num=(c1-'0')*10+(ch2-'0');
                    if(num<=26){
                        count=(count%mod  +  numDecodings_memo(s,idx+2,dp)%mod)%mod;
                    }
                    
                }else{
                    if(s.charAt(idx)=='1'){
                         count=(count%mod  +  9*numDecodings_memo(s,idx+2,dp)%mod)%mod;
                    }else if(s.charAt(idx)=='2'){
                         count=(count%mod  +  6*numDecodings_memo(s,idx+2,dp)%mod)%mod;
                    }
                }
            }
        }
        
        return dp[idx]=count;
    }
    
    public int numDecodings(String s) {
        long[]dp=new long[s.length()+1];
        Arrays.fill(dp,-1);
        long ans=numDecodings_memo(s,0,dp);
        
        return (int)ans;
    }
}