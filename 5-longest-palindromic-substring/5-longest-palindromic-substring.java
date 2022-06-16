class Solution {
    public String longestPalindrome(String s) {
        int[][]dp=new int[s.length()+1][s.length()+1];
        
        int si=0;
        int count=0;
        int ans=0;
        
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;j<s.length();j++,i++){
                if(gap==0){
                    dp[i][j]=1;
                }else if(gap==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=2;
                }else{
                    dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0?dp[i+1][j-1]+2:0;
                }
                
                count+=dp[i][j]>0?1:0;
                 if(dp[i][j]>ans){
                    ans=dp[i][j];
                    si=i;
                 }
            }
        }
        
        
        return (s.substring(si,si+ans));
        
    }
}