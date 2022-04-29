class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>sans=new ArrayList<>();
        
        partition_generate(0,sans,ans,s);
        return ans;
    }
    
    public void partition_generate(int index,List<String>sans,List<List<String>>ans,String s){
        
        if(index==s.length()){
            ans.add(new ArrayList<>(sans));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                sans.add(s.substring(index,i+1));
                partition_generate(i+1,sans,ans,s);
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