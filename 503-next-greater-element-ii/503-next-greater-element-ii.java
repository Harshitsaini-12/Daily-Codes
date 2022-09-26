class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n=nums.length;
        int[]ans=new int[n];
        
        Stack<Integer>st=new Stack<>();
        
       for(int i=n-1;i>=0;i--){
           while(st.size()>0 && st.peek()<=nums[i]){
               st.pop();
           }
           
           st.push(nums[i]);
       }
        
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && st.peek()<=nums[i])st.pop();
            
            ans[i]=st.size()==0 ? -1 : st.peek();
            
            st.push(nums[i]);
        }
        
        return ans;
    }
}