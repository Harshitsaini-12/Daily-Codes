class Solution {
    public boolean wordPattern(String pattern, String s) {
        
		String words[] = s.split(" ");
        
        if(words.length!=pattern.length()){
            return false;
        } 
        
        HashMap<Character, String> hm = new HashMap<>();
        
        for(int i=0; i<pattern.length(); i++){
           char current_char=pattern.charAt(i);
            
            if(hm.containsKey(current_char)){
                if(!hm.get(current_char).equals(words[i])){
                    return false;
                }
            }else{
                if(hm.containsValue(words[i]))return false;
                
                hm.put(current_char,words[i]);
            }
        }
        return true;
    }
}