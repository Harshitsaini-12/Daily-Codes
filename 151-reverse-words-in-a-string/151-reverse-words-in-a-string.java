class Solution {
    public String reverseWords(String s) {
        Stack<String>st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        
        for(String ss:s.trim().split(" ")){
            if(!ss.isEmpty())st.push(ss);
        }
        
        while(st.size()>0){
            sb.append(st.pop());
            sb.append(" ");
        }
        
        return sb.toString().trim();
        
    }
}