class Solution {
    public int minCost(String colors, int[] neededTime) {
        int i=0;
        int j=0;
        int totalTime=0;
        int n=colors.length();
        
        while(i<n && j<n){
            int maxElem=0;
            int windowTotal=0;
            
            while(j<n && colors.charAt(i)==colors.charAt(j)){
                
                maxElem=Math.max(maxElem,neededTime[j]);
                windowTotal+=neededTime[j];
                
                j++;
            }
            
            i=j;
            totalTime+=(windowTotal-maxElem);
        }
            
        return totalTime;
    }
}