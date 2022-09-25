class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        
        Map<Integer,String>hm=new HashMap<>();
        
        for(int i=0;i<names.length;i++){
            hm.put(heights[i],names[i]);
        }
        
        Arrays.sort(heights);
        
        String[]ans=new String[heights.length];
        
        int j=0;
        
        for(int i=heights.length-1;i>=0;i--){
            ans[j]=hm.get(heights[i]);
            j++;
        }
        
        return ans;
        
    }
}