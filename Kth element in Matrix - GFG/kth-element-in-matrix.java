// { Driver Code Starts
//Initial Template for Java

import java.util.*;
class KthSmallestElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t>0)
		{
			int n=Integer.parseInt(sc.next());
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
    				a[i][j]=Integer.parseInt(sc.next());
    		
			int k=Integer.parseInt(sc.next());
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(a,n,k));
		    
		    t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
	public static int kthSmallest(int[][]matrix,int n,int k)
	{
        //code here.
        
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