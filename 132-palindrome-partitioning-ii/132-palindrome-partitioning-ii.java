class Solution {
    public int minCut(String s) {
        return minCuts(s,0,s.length()-1,new HashMap<>());
    }
    
    public int minCuts(String s,int start,int end,HashMap<String,Integer>hm){
        
        if(isPalindrome(s,start,end))return 0;
        
        int ans=1000000;
        
        String key=start+"#"+end;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
        if(start>end)return 0;
        
        for(int i=start;i<end;i++){
            if(isPalindrome(s,start,i)){
               int rightans=minCuts(s,i+1,end,hm);
            
               int tempans=rightans+1;
               ans=Math.min(ans,tempans);
            }
         
        }
        
        hm.put(key,ans);
        return ans;
    }
    
    
    public boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))return false;
            
            i++;
            j--;
        }
        return true;
    }
}