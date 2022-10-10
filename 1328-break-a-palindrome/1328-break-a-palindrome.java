class Solution {
    public String breakPalindrome(String p) {
        char[]ans=p.toCharArray();
        int n=ans.length;
        
        for(int i=0;i<n/2;i++){
            if(ans[i]!='a'){
                ans[i]='a';
                return String.valueOf(ans);
            }
        }
        
        //if all the characters are 'a'
        ans[n-1]='b';
        return n<2 ? "" : String.valueOf(ans);
    }
}