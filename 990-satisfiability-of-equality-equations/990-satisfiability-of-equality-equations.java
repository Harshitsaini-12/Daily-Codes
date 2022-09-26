class Solution {
    int[]par;
    
    public int findPar(int u){
        return par[u]==u ? u : (par[u]=findPar(par[u]));
    }
    
    public boolean equationsPossible(String[] equation) {

        par=new int[26];
        
        for(int i=0;i<26;i++)par[i]=i;
        
        for(String s:equation){
            if(s.charAt(1)=='='){
                int p1=findPar(s.charAt(0)-'a');
                int p2=findPar(s.charAt(3)-'a');
                
                if(p1!=p2){
                    par[p1]=p2;
                }
            }
        }
        
        for(String s:equation){
            if(s.charAt(1)=='!'){
                int p1=findPar(s.charAt(0)-'a');
                int p2=findPar(s.charAt(3)-'a');
                
                if(p1==p2){
                    return false;
                }
            }
        }
        
        return true;
    }
}