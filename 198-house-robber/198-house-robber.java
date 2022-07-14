class Solution {
    public int rob(int[] arr) {
        int inc=arr[0];
       int exc=0;
       
       for(int i=1;i<arr.length;i++){
           
           int newnc = arr[i] + exc;
           int newexc = Math.max(inc,exc);
           
           inc=newnc;
           exc=newexc;
       }
       
       int ans=Math.max(inc,exc);
        return ans;
    }
    
}