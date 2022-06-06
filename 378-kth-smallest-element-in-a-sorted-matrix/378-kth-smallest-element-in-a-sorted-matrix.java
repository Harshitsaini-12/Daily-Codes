class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->{
            int r1=a/m;int c1=a%m;
            int r2=b/m;int c2=b%m;
            
            return matrix[r1][c1]-matrix[r2][c2];
        });
        
        for(int i=0;i<n;i++){
            pq.add(i*m+0);
        }
        
        int r=0;int c=0;
        
        while(k-- > 0){
            int idx=pq.remove();
            
            r = idx / m;
            c = idx % m;
            
            if(c+1 < m){
                pq.add(r*m+c+1);
            }
        } 
        
        return matrix[r][c];
    }
}