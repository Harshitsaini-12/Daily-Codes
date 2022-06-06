class Solution {
    public String removeDuplicateLetters(String s) {
        int[]freq=new int[26];
        boolean[]exist=new boolean[26];
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        
        Stack<Character>st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']--;
            
            if(exist[ch-'a'])continue;
            
            while(st.size()>0 && st.peek()>=ch && freq[st.peek()-'a']>0){
                int rem=st.pop();
                exist[rem-'a']=false;
            }
            
            st.push(ch);
            exist[ch-'a']=true;
        }
        char[]ans=new char[st.size()];
        int i=ans.length-1;
        
        while(i>=0){
            ans[i--]=st.pop();
        }
        
        
        return new String(ans);
    }
}