class Solution {
    public boolean canJump(int[] nums) {
        return ans(nums,0,new HashMap<Integer,Boolean>());
    }
    
    public boolean ans(int[]nums,int ci,HashMap<Integer,Boolean>hm){
        
        if(ci>=nums.length-1)return true;
        
        
         int currJump=nums[ci];
        
          if(currJump>= nums.length - ci)
            return true;
        
        int key=ci;
        
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        
      
        
        boolean fans=false;
        
        for(int i=1;i<=currJump;i++){
           boolean x=ans(nums,ci+i,hm);
            fans=fans||x;
        }
        
        hm.put(key,fans);
        return fans;
    }
}