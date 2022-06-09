class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        
        HashMap<Integer,Integer>[]dp=new HashMap[n];
        
        for(int i=0;i<n;i++)dp[i]=new HashMap<>();
        
        int len=0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                
                int diff=nums[i]-nums[j];
                int currlen=dp[i].getOrDefault(diff,0);
                int newLen=dp[j].getOrDefault(diff,1)+1;
                
                dp[i].put(diff,Math.max(currlen,newLen));
                len=Math.max(len,dp[i].get(diff));
            }
        }
        
        return len;
    }
}