class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int val:nums)xor^=val;
        int mask=(xor&(-xor)); // finding the rsb
        
        int a=0;
        int b=0;
        
        for(int val:nums){
            if((val&mask)==0){
                a^=val;
            }else{
                b^=val;
            }
        }
        
        return new int[]{a,b};
    }
}