class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        List<List<Integer>>ans=new ArrayList<>();
        HashMap<Integer,List<Integer>>hm=new HashMap<>();
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            int curr=arr[i];
            List<Integer>temp=new ArrayList<>();
            
            if(hm.containsKey(curr)){
                temp=hm.get(curr);
                
            }
            
            temp.add(i);
            hm.put(curr,temp);
            
            if(temp.size()==curr){
                ans.add(temp);
                hm.remove(curr);
            }
            
        }
        
        return ans;
    }
}