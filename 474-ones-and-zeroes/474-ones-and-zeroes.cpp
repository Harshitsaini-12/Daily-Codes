class Solution {
public:
    int dp[101][101][601];
    
    int memo(vector<string>&strs,int m,int n,int idx){
        
        if(idx>=strs.size() || m<0 || n<0)return 0;
        
        if(dp[m][n][idx]!=-1){
            return dp[m][n][idx];
        }
        
        int zero_count=count(strs[idx].begin(),strs[idx].end(),'0');
        int one_count=count(strs[idx].begin(),strs[idx].end(),'1');
            
        
        if(m-zero_count>=0 && n-one_count>=0){
            return  dp[m][n][idx]=max(1+memo(strs,m-zero_count,n-one_count,idx+1),memo(strs,m,n,idx+1));
        }else{
            return  dp[m][n][idx]=memo(strs,m,n,idx+1);
        }
    
    }
    
    int findMaxForm(vector<string>& strs, int m, int n) {
        
        memset(dp,-1,sizeof(dp));
        
        return memo(strs,m,n,0);
    }
};