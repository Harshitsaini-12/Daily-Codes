class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int>st;
        int n=heights.size();
        int maxArea=0;
        
        for(int i=0;i<=n;i++){
            while(!st.empty() && (i==n || heights[st.top()]>=heights[i])){
                
                int h=heights[st.top()];
                st.pop();
                
                int w;
                if(st.empty())w=i;
                else w=i-st.top()-1;
                
                maxArea=max(maxArea,w*h);
            }
            st.push(i);
        }

        return maxArea;
    }
};