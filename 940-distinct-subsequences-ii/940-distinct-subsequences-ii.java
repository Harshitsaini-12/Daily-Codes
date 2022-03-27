class Solution {
    public int distinctSubseqII(String str) {
     long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        HashMap<Character, Integer> pos = new HashMap<>();
        
        for(int i = 1; i < dp.length; i++) {
        	dp[i] = (dp[i-1]*2) % 1000000007;
        	if(pos.containsKey(str.charAt(i - 1)))
        		dp[i] = (dp[i] - dp[pos.get(str.charAt(i-1)) - 1]);
            dp[i] = dp[i] % 1000000007;
        	pos.put(str.charAt(i - 1), i);
        }
        
        if(dp[str.length()] < 0){
            dp[str.length()] += 1000000007;
        }
        
        return (int)(dp[str.length()] - 1) % 1000000007;
    }
}