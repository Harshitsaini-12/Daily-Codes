class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
        int[][]dir={{1,0},{0,1},{0,-1},{-1,0}};
        
        int[][]indegree=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                for(int d=0;d<dir.length;d++){
                    int r=dir[d][0]+i;
                    int c=dir[d][1]+j;
                    
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c]<matrix[i][j]){
                        indegree[r][c]++;
                    }
                }
            }
        }
        
        LinkedList<Integer>q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(indegree[i][j]==0){
                    q.addLast(i*m+j);
                }
            }
        }
        
        int level=0;
        
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                int vtx=q.removeFirst();
                int rr=vtx/m;
                int cc=vtx%m;
                
                for(int i=0;i<dir.length;i++){
                    int r=rr+dir[i][0];
                    int c=cc+dir[i][1];
                    
                    if(r>=0 && c>=0 && r<n && c<m && matrix[r][c] < matrix[rr][cc]){
                        indegree[r][c]--;
                        if(indegree[r][c]==0){
                            q.addLast(r*m+c);
                        }
                    }
                }
                
            }
            level++;
        }
        
        return level;
    }
}