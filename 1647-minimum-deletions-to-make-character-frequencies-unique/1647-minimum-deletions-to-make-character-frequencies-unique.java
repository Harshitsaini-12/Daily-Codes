class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }
        
        int operation=0;
        HashMap<Integer,Boolean>omap=new HashMap<>();
        
        for(int val:hm.values()){
            if(omap.containsKey(val)){
                
                while(val-1>=0){
                    if(omap.containsKey(val-1)){
                         val--;
                        operation++;
                       
                    }else{
                        omap.put(val-1,true);
                        operation++;
                        break;
                    }
                }
                
            }else{
                omap.put(val,true);
            }
        }
        
        return operation;
    }
}