class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        
        int n=capacity.length;
        int count=0;
        
        for(int i=0;i<n;i++){
            capacity[i]-=rocks[i];
        }
        
        Arrays.sort(capacity);
        
        for(int i=0;i<n && additionalRocks>0 ;i++){
            if(capacity[i]<=additionalRocks)count++;
            
            additionalRocks-=capacity[i];
        }
        
        return count;
    }
}