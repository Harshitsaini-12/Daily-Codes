class Solution {
public:
    int f(int i,int j,vector<int>&cuts,vector<vector<int>>&dp){
        if(i>j)return 0;

        if(dp[i][j]!=-1)return dp[i][j];

        int mini=1e8;

        for(int cut=i;cut<=j;cut++){
            int cost=cuts[j+1]  - cuts[i-1] + f(i,cut-1,cuts,dp) + f(cut+1,j,cuts,dp);

            mini=min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    
    int minCost(int n, vector<int>& cuts) {
        
        vector<vector<int>>dp(102,(vector<int>(102,-1)));
        
        cuts.push_back(n);
        cuts.insert(cuts.begin(),0);
        sort(cuts.begin(),cuts.end());
        
        return f(1,cuts.size()-2,cuts,dp);
    }
};