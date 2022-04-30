class Trie {
    private class Node{
        Node[]child;
        boolean isEnd;
        
        Node(){
          child=new Node[26];
        }
    }
    
    private final Node root;
    
    public Trie() {
        root=new Node(); 
    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.child[word.charAt(i)-'a']==null){
                curr.child[word.charAt(i)-'a']=new Node();
            }
            curr=curr.child[word.charAt(i)-'a'];
        }
        
        curr.isEnd=true;
            
    }
    
    public boolean search(String word) {
        Node curr=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(curr.child[ch-'a']==null)return false;
            curr=curr.child[ch-'a'];
        }
        
        return curr.isEnd;
    }
    
    public boolean startsWith(String word) {
         Node curr=root;
        
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            
            if(curr.child[ch-'a']==null)return false;
            curr=curr.child[ch-'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */