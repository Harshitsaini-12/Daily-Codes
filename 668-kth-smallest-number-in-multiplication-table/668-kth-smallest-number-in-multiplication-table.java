class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low=1;
        int high=n*m;
        
        while(low<high){
            int mid=low+((high-low)>>1);
            
            int count=0;
            int j=n;
            
            for(int i=1;i<=m;i++){
                
                while(j>=1 && mid<i*j){
                    j--;
                }
                
                count+=j;
            }
            
            if(count<k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        
        return low;
    }
}