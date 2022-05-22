class Solution {
    public int minCut(String s) {
        int n=s.length();
        
        boolean[][]pdp=new boolean[n+1][n+1];
        
        for(int gap=0;gap<n;gap++){
            for(int j=gap,i=0;j<n;i++,j++){
                if(gap==0){
                    pdp[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j) && gap==1){
                    pdp[i][j]=true;
                }else{
                    pdp[i][j]=s.charAt(i)==s.charAt(j)&& pdp[i+1][j-1];
                }
            }
        }
        
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        
        return cut(s,0,n-1,dp,pdp);
    }
    
    public int cut(String s,int si,int ei,int[]dp,boolean[][]pdp){
        
        if(pdp[si][ei])return 0;
        
        if(dp[si]!=-1)return dp[si];
        
        int minAns=(int)1e8;
        
        for(int cut=si;cut<=ei;cut++){
            if(pdp[si][cut]){
                minAns=Math.min(minAns,cut(s,cut+1,ei,dp,pdp)+1);
            }
        }
        
        return dp[si]=minAns;
    }
}