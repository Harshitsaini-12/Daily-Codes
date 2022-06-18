class Solution {
    public int trap(int[] height) {
//         Stack<Integer>st=new Stack<>();
//         int ans=0;
        
//         for(int i=0;i<height.length;i++){
//             while(st.size()>0 && height[st.peek()]<=height[i]){
                
//                 int rm=i;
//                 int curr=height[st.pop()];
                
//                 if(st.size()==0)break;
                
//                 int lm=st.peek();
//                 int width=rm-lm-1;
                
//                 ans+=(Math.min(height[lm],height[rm])-curr)*width;
                
//             }
//          st.push(i);
//         }
        
        int r=height.length-1;
        int l=0;
        int lmax=0;
        int rmax=0;
        int ans=0;
        
        while(l<r){
            lmax=Math.max(lmax,height[l]);
            rmax=Math.max(rmax,height[r]);
            
            if(rmax<lmax){
                ans+=rmax-height[r];
                r--;
            }else{
                ans+=lmax-height[l];
                l++;
            }
        }
        return ans;
    }
}

//2 aproach tc-o(n) sc-o(1)

//tc-o(n)