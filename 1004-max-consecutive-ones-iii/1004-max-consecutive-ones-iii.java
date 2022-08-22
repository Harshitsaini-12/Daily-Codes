class Solution {
    public int longestOnes(int[] arr, int k) {
       int j=-1;
       int ans=0;
       int zero=0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)zero++;
            
            if(zero>k){
                j++;
                if(arr[j]==0)zero--;
            }
            
            int len=i-j;
            ans=Math.max(len,ans);
        }
        
        return ans;
    }
}