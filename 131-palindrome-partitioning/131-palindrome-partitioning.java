class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>sans=new ArrayList<>();
        
        partition(0,s,ans,sans);
        return ans;
    }
    
    public void partition(int index,String s,List<List<String>>ans,List<String>sans){
        
        if(index==s.length()){
            ans.add(new ArrayList<>(sans));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                
                sans.add(s.substring(index,i+1));
                partition(i+1,s,ans,sans);
                sans.remove(sans.size()-1);
            }
        }
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