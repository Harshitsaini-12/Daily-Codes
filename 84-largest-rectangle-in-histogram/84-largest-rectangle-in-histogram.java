class Solution {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer>st=new LinkedList<>();
        st.addFirst(-1);
        int n=heights.length;
        
        int maxArea=0;
        
        for(int i=0;i<=n;i++){
            int val = i==n?0:heights[i];
            
            while(st.getFirst()!=-1 && val<=heights[st.peek()]){
                int rm=i;
                
                int h=heights[st.removeFirst()];
                int lm=st.peek();
                
                maxArea=Math.max(maxArea,h*(rm-lm-1));
                
            }
          st.addFirst(i);
        }

        return maxArea;
    }
}