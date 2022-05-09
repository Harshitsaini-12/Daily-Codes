class Solution {
    public List<String> letterCombinations(String digits) {

        if(digits.length()==0){
            return new ArrayList<>();
        }
        
        List<String>ans=new ArrayList<>();
        getKPC(digits,0,ans,"");
        return ans;
        
    }
    
    static String[] codes={
         "",
        "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
       "wxyz"
    };
    
    private static int getKPC(String digits,int idx,List<String>ans,String psf){
        if(idx==digits.length()){
            ans.add(psf);
            return 1;
        }
    
        int count=0;
        int val=digits.charAt(idx)-'0';
        String code=codes[val];
        
        for(int i=0;i<code.length();i++){
            count+=getKPC(digits,idx+1,ans,psf+code.charAt(i));
        }
        
        return count;
    }
}