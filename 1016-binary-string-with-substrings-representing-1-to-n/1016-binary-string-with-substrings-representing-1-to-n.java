class Solution {
    public boolean queryString(String S, int n) {
        
        for ( int i = 1; i <= n; i++ ) {
                String s = Integer.toBinaryString(i);
                if (S.indexOf(s) == -1 ) return false; 
         }
        return true;
    }
}