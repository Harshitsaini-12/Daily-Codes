class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer>hm=new HashMap<>();
        int n=messages.length;
        
        for(int i=0;i<senders.length;i++){
            if(hm.containsKey(senders[i])){
                hm.put(senders[i],hm.get(senders[i])+messages[i].split(" ").length);
            }else{
                hm.put(senders[i],messages[i].split(" ").length);
            }
        }
        
        String ans="";
        int max=0;
        
        for(String key:hm.keySet()){
            if(hm.get(key)>max){
                max=hm.get(key);
                ans=key;
            }else if(hm.get(key)==max && ans.compareTo(key)<0){
                ans=key;
            }
        }
        
        return ans;
    }
}