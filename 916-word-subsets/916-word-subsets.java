class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String>ans=new ArrayList<>();
        
        int[]tar=new int[26];
        
        for(String s:words2){
            int[]temp=new int[26];
            
            for(char ch:s.toCharArray()){
                temp[ch-'a']++;
                tar[ch-'a']=Math.max(tar[ch-'a'],temp[ch-'a']);
            }
        }
        
        for(String s:words1){
            int[]temp=new int[26];
            
            for(char ch:s.toCharArray()){
                temp[ch-'a']++;
            }
            
            if(subset(tar,temp)){
                ans.add(s);
            }
        }
        
        return ans;
    }
    
    public boolean subset(int[]child,int[]parent){
        for(int i=0;i<26;i++){
            if(parent[i]<child[i])return false;
        }
        return true;
    }
}