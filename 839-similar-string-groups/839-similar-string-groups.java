class Solution {
    int[]par,size;
    
    public int findPar(int u){
        return par[u]==u ? u : (par[u]=findPar(par[u]));
    }
    
    public boolean isSimilar(String s1,String s2){
        int n=s1.length();
        
        int count=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i) && ++count>2)return false;
        }
        
        return true;
    }
    
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        par=new int[n];
        
        for(int i=0;i<n;i++)par[i]=i;
        
        int noOfSets=n;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(strs[i],strs[j])){
                    int p1=findPar(i);
                    int p2=findPar(j);
                    
                    if(p1!=p2){
                        par[p1]=p2;
                        noOfSets--;
                    }
                }
            }
        }
        
        return noOfSets;
    }
}