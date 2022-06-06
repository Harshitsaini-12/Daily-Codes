class Solution {
    public String minRemoveToMakeValid(String s) {
        int n=s.length();
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.size()>0 && s.charAt(st.peek())=='('){
                    st.pop();
                }else{
                    st.push(i);
                }
            }
        }
        
        char[]ans=s.toCharArray();
        
        while(st.size()>0){
            int idx=st.pop();
            ans[idx]='.';
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<ans.length;i++){
            if(ans[i]!='.')sb.append(ans[i]);
        }
        
        return sb.toString();
    }
}