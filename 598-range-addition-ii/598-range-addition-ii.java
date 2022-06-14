class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0 || ops==null)return m*n;
        
        int row=Integer.MAX_VALUE;
        int col=Integer.MAX_VALUE;
        
        for(int[]o : ops){
            row=Math.min(row,o[0]);
            col=Math.min(col,o[1]);
        }
        
        return row*col;
    }
}