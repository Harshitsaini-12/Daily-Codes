class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==0 || s==null)return 0;
        
        HashSet<Character>set=new HashSet<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(set.contains(ch))set.remove(ch);
            else set.add(ch);
        }
        
        return set.size()==0?s.length():s.length()-set.size()+1;
    }
}