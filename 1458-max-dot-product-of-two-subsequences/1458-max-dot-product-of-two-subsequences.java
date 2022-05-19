class Solution {
    public int maxDotProduct_memo(int[]nums1,int[]nums2,int[][]dp,int n,int m){
        if(n==0 || m==0){
            return dp[n][m]=-(int)1e7;
        }
        
        if(dp[n][m]!=-(int)1e8)return dp[n][m];
        
        int val=nums1[n-1]*nums2[m-1];
        int acceptBothNumber=maxDotProduct_memo(nums1,nums2,dp,n-1,m-1)+val;
        int a=maxDotProduct_memo(nums1,nums2,dp,n-1,m);
        int b=maxDotProduct_memo(nums1,nums2,dp,n,m-1);
        
        return dp[n][m]=Math.max(Math.max(acceptBothNumber,val),Math.max(a,b));
        
    }
    
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        
        int[][]dp=new int[n+1][m+1];
        
        for(int[]d:dp)Arrays.fill(d,-(int)1e8);
        
        return maxDotProduct_memo(nums1,nums2,dp,n,m);
    }
}