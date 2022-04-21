class Solution {
    public String reverseWords(String s) {
        Stack<String>st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        
        for(String a:s.trim().split(" ")){
            if(!a.isEmpty()){
                  st.push(a);
            }
        }
        
        while(st.size()>0){
            sb.append(st.pop());
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}