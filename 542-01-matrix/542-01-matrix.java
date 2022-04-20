class Solution {
     public class Pair{
        int x;
        int y;

        Pair(int x,int y){
          this.x=x;
          this.y=y;
        }
  }
    
    int[][]dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        LinkedList<Pair>q=new LinkedList<>();
    
        for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              if(matrix[i][j]==0){
                q.addLast(new Pair(i,j));
              }else{
                matrix[i][j]=-1;
              }
          }
        }

    while(q.size()>0){
          Pair rem=q.removeFirst();

          for(int i=0;i<dir.length;i++){
            int rdash=rem.x+dir[i][0];
            int cdash=rem.y+dir[i][1];

if(rdash>=0 && cdash>=0 && rdash<matrix.length && cdash<matrix[0].length && matrix[rdash][cdash]<0){
                  matrix[rdash][cdash]=matrix[rem.x][rem.y]+1;
                  q.addLast(new Pair(rdash,cdash));
            }
          }

    }


    return matrix;
    }
}