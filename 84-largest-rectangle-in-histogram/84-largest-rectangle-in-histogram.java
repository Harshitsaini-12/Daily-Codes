class Solution {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer>st=new LinkedList<>();
        st.addFirst(-1);
        int n=heights.length;
        
        int maxArea=0;
        
        for(int i=0;i<n;i++){
            while(st.getFirst()!=-1 && heights[i]<=heights[st.peek()]){
                int h=heights[st.removeFirst()];
                int w=i-st.getFirst()-1;
                maxArea=Math.max(maxArea,h*w);
            }
          st.addFirst(i);
        }
        
        while(st.getFirst()!=-1 ){
                int h=heights[st.removeFirst()];
                int w=n-st.getFirst()-1;
                maxArea=Math.max(maxArea,h*w);
        }
        
        return maxArea;
    }
}