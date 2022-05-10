class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        combo(k,n,ans,1,new ArrayList<>());
        return ans;
    }
    
    public void combo(int k,int n,List<List<Integer>>ans,int start,List<Integer>sans){
        if(sans.size()==k){
            if(n==0){
                List<Integer>comb=new ArrayList<>(sans);
                ans.add(comb);
                return;
            }
        }
        
        for(int i=start;i<=9;i++){
            sans.add(i);
            combo(k,n-i,ans,i+1,sans);
            sans.remove(sans.size()-1);
        }
    }
}