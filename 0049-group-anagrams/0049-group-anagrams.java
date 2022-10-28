class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<HashMap<Character,Integer>,List<String>>hm=new HashMap<>();
        
        
        for(String st:strs){
            HashMap<Character,Integer>fm=new HashMap<>();
            
            for(int i=0;i<st.length();i++){
                char ch=st.charAt(i);
                
                fm.put(ch,fm.getOrDefault(ch,0)+1);
            }
            
            
            if(hm.containsKey(fm)==false){
                List<String>ans=new ArrayList<>();
                ans.add(st);
                hm.put(fm,ans);
                
            }else{
                List<String>ans=hm.get(fm);
                ans.add(st);
            }
        }
        
        List<List<String>> res=new ArrayList<>();
        
       for(List<String> val:hm.values()){
           res.add(val);
       }
        
        return res;
    }
}