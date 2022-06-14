class Solution {
    public int[] sortedSquares(int[] nums) {
        int []res=new int[nums.length];
        
        int i=0;
        int j=nums.length-1;
        int index=nums.length-1;
        
        while(i<=j){
            int val1=nums[i]*nums[i];
            int val2=nums[j]*nums[j];
            
            if(val1<val2){
             res[index]=val2;
                j--;
            }else{
                res[index]=val1;
                i++;
            }
          index--;
        }
        
        return res;
    }
}

//tc 0(n);
//sc 0(n);