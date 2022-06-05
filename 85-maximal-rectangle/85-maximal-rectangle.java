class Solution {
    public int maximalRectangle(char[][] arr) {
        if(arr.length==0 || arr[0].length==0)return 0;
        int n=arr.length;int m=arr[0].length;
        
        int maxArea=0;
        int[]height=new int[m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                height[j]=arr[i][j]=='0'?0:height[j]+1;
            }
            maxArea=Math.max(maxArea,largestRectangleArea(height));
        }
        return maxArea;
    }
    
    public static int largestRectangleArea(int[] heights) {
        
        Stack<Integer>ls=new Stack<>();
        ls.push(0);
        int []lb=new int[heights.length];
        lb[0]=-1;
        
        for(int i=1;i<heights.length;i++){
            while(ls.size()>0 && heights[i]<=heights[ls.peek()]){
                ls.pop();
            }
            
            if(ls.size()==0){
                lb[i]=-1;
            }else{
                lb[i]=ls.peek();
            }
            ls.push(i);
        }
        
       Stack<Integer>rs=new Stack<>();
        rs.push(heights.length-1);
         int []rb=new int[heights.length];
        rb[heights.length-1]=heights.length;
        
        for(int i=heights.length-2;i>=0;i--){
            while(rs.size()>0 && heights[i]<=heights[rs.peek()]){
                rs.pop();
            }
            
            if(rs.size()==0){
                rb[i]=heights.length;
            }else{
                rb[i]=rs.peek();
            }
            rs.push(i);
        }
        
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<heights.length;i++){
            int w=rb[i]-lb[i]-1;
            int h=heights[i];
            
            int area=w*h;
            max=Math.max(max,area);
        }
        
        return max;
    }
}