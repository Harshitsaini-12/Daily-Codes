import java.util.*;
class Solution {
    public class Node{
        Node[]child=new Node[26];
        String str;
    }
    
    public void insert(Node root,String s){
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(root.child[ch-'a']==null){
                root.child[ch-'a']=new Node();
            }
            
            if(root.str!=null)return;
            
            root=root.child[ch-'a'];
        }
        
        root.str=s;
    }
    
    public String getPrefix(Node root,String s){
        
        StringBuilder prefix=new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(root.child[ch-'a']==null)return null;
            
            root=root.child[ch-'a'];
            
            if(root.str!=null){
                return root.str;
            }
        }
        return null;
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root=new Node();
        
       for(String s:dictionary){
          insert(root,s);
       }
        
        StringBuilder ans=new StringBuilder();
        StringTokenizer st=new StringTokenizer(sentence);
        
        while(st.hasMoreTokens()){
            String word=st.nextToken();
            
            String prefix=getPrefix(root,word);
            
            if(prefix!=null){
                ans.append(prefix);
            }else{
                ans.append(word);
            }
            ans.append(" ");
        }
        
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }
}