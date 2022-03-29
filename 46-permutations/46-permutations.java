class Solution {
    
private static int permute_(List<List<Integer>>ans,List<Integer>sans,int elemntUsed,int[]nums){
       if(elemntUsed==nums.length){
           List<Integer>base=new ArrayList<>(sans);
           ans.add(base);
           return 1;
       }
    
       int count=0;
    
       for(int i=0;i<nums.length;i++){
           if(nums[i]>-11){
               int val=nums[i];
               nums[i]=-11;//used
               sans.add(val);
               
               count+=permute_(ans,sans,elemntUsed+1,nums);
               
               nums[i]=val;//unused
               sans.remove(sans.size()-1);
           }
       }
    return count;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>sans=new ArrayList<>();
        
        permute_(ans,sans,0,nums);
        return ans;
        
    }
}