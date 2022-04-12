class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int ans=n;
        int i=0;
        while(i<n){
            ans^=nums[i]^(i++);
        }
        
        return ans;
    }
}

//using xor property