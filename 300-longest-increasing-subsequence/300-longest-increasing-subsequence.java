class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int ans=1;
//         int n=nums.length;
        
//         int[]dp=new int[n];
//         Arrays.fill(dp,1);
        
         // for(int i=0;i<n;i++){
         //     dp[i]=1;
         //     for(int j=i-1;j>=0;j--){
         //         if(nums[i]>nums[j]){
         //             dp[i]=Math.max(dp[i],dp[j]+1);
         //         }
         //     }
         //     maxlen=Math.max(dp[i],maxlen);
         // }
//         return ans;

//     }
    
    // 0(nlogn)
    
    public int binary_search(int val,List<Integer>list){
        int li=0,ri=list.size();
        
        while(li<ri){
            int mid=(li+ri)/2;
            
            if(val<=list.get(mid)){
                ri=mid;
            }else{
                li=mid+1;
            }
        }
        
        return li;
    }
    
    
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        ArrayList<Integer>list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int idx=binary_search(nums[i],list);
            
            if(idx==list.size())list.add(nums[i]);
            else{
                list.set(idx,nums[i]);
            }
        }
        return list.size();
    }
}

        
//         int n=nums.length;
//         int []dp=new int[n];
//         int maxlen=0;
        
//         for(int i=0;i<n;i++){
//             maxlen=Math.max(maxlen,lis(nums,i,dp));
//         }
        
//         return maxlen;
    // }
    
//     private int lis(int[]nums,int idx,int[]dp){
//         int maxlen=1;
        
//         if(dp[idx]!=0){
//             return dp[idx];
//         }
        
//         for(int i=idx-1;i>=0;i--){
//             if(nums[idx]>nums[i]){
//                 int ans=lis(nums,i,dp);
//                 maxlen=Math.max(maxlen,ans+1);
//             }
//         }
        
//         return dp[idx]=maxlen;