class Solution {
public:
//     int f(int i,int j,vector<int>&cuts,vector<vector<int>>&dp){
//         if(i>j)return 0;

//         if(dp[i][j]!=-1)return dp[i][j];

//         int mini=1e8;

//         for(int cut=i;cut<=j;cut++){
//             int cost=cuts[j+1]  - cuts[i-1] + f(i,cut-1,cuts,dp) + f(cut+1,j,cuts,dp);

//             mini=min(mini,cost);
//         }
        
//         return dp[i][j]=mini;
//     }
    
    int minCost(int n, vector<int>& cuts) {
        
        vector<vector<int>>dp(103,(vector<int>(103,0)));
        
        cuts.push_back(n);
        cuts.insert(cuts.begin(),0);
        sort(cuts.begin(),cuts.end());
        int N=cuts.size();
        
        for(int i=N-2;i>=1;i--){
            for(int j=1;j<=N-2;j++){
                if(i>j)continue;

                int mini=1e8;

                for(int cut=i;cut<=j;cut++){
                    int cost=cuts[j+1]  - cuts[i-1] + dp[i][cut-1] + dp[cut+1][j];

                    mini=min(mini,cost);
                }

                dp[i][j]=mini;
            }
        }
        
        return dp[1][cuts.size()-2];
        
    }
};

//variation of cut type dp