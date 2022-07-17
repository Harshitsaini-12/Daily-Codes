class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int ans=-1;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            int sum=findSum(nums[i]);
            
            if(hm.containsKey(sum)){
                ans=Math.max(ans,hm.get(sum) + nums[i]);
                
                if(hm.get(sum)<nums[i]){
                    hm.put(sum,nums[i]);
                }
                
            }else{
                hm.put(sum,nums[i]);
            }
        }
        
        return ans;
    }
    
    public int findSum(int n){
        int ans=0;
        
        while(n!=0){
            ans+=n%10;
            n/=10;
        }
        return ans;
    }
}