class Solution {
    public int subarraysum(int[]nums,int k){
        int ans=0;
        int si=0;
        int ei=0;
        int count=0;
        int n=nums.length;
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        
        while(ei<n){
            if(!hm.containsKey(nums[ei])){
                count++;
            }
            
            hm.put(nums[ei],hm.getOrDefault(nums[ei],0)+1);
            ei++;
            
            while(count>k){
                if(hm.get(nums[si])==1){
                    count--;
                }
                
                hm.put(nums[si],hm.get(nums[si])-1);
                
                if(hm.get(nums[si])==0){
                    hm.remove(nums[si]);
                }
                
                si++;
            }
            ans+=(ei-si);
        }
        
        return ans;
    }
    
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysum(nums,k)-subarraysum(nums,k-1);
    }
}