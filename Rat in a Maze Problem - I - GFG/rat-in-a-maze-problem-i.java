// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
// Initial Template for Java

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String>ans=new ArrayList<>();
        
        generateAllPaths(m,0,0,n,"",ans);
        Collections.sort(ans);
        return ans;
    }
    
    public static void generateAllPaths(int [][]grid,int r,int c,int n,String curr,ArrayList<String>ans){
        if(r<0 || r>=n || c<0 || c>=n || grid[r][c]==0)return;
        
        if(r==n-1 && c==n-1){
            ans.add(curr);
            return;
        }
        
        grid[r][c]=0;
        
        //up move
        generateAllPaths(grid,r-1,c,n,curr+"U",ans);
        
        //down move
         generateAllPaths(grid,r,c+1,n,curr+"R",ans);
        
        // left move
         generateAllPaths(grid,r+1,c,n,curr+"D",ans);
         
        //right move
         generateAllPaths(grid,r,c-1,n,curr+"L",ans);
        
        grid[r][c]=1;
        return;
    }
}