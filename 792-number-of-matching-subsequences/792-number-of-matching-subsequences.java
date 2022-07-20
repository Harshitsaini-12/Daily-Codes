class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<String,Integer>hm=new HashMap<>();
        
        for(String word:words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        
        int ans=0;
        char c[]=s.toCharArray();
        
        for(String str:hm.keySet()){
            
            char[]temp=str.toCharArray();
            int i=0;
            int j=0;
            
            while(i<c.length && j<temp.length){
                if(c[i]==temp[j]){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            
            if(j==temp.length)ans+=hm.get(str);
        }
        
        return ans;
    }
}