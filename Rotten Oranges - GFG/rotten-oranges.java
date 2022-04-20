// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
      public class Pair{
        int row;
        int col;
        
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    
     public int orangesRotting(int[][] arr) {
        LinkedList<Pair>q=new LinkedList<>();
        
        int fresh=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==1){
                    fresh++;
                }else if(arr[i][j]==2){
                    q.addLast(new Pair(i,j));
                }
            }
        }
        
        if(fresh==0)return 0;
        
        int level=-1;
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
            
        while(q.size()>0){
            int size=q.size();
             level++;
            
            while(size-->0){
                Pair rem=q.removeFirst();
                
                for(int i=0;i<dir.length;i++){
                    int rdash=rem.row+dir[i][0];
                    int cdash=rem.col+dir[i][1];
                    
 if(rdash>=0 && cdash>=0 && rdash<arr.length && cdash<arr[0].length && arr[rdash][cdash]==1){
        q.addLast(new Pair(rdash,cdash));
        arr[rdash][cdash]=0;
        fresh--;
    }
                }
            }
        }
        
        if(fresh!=0){
            return -1;
        }else{
            return level;
        }
        
    }
}