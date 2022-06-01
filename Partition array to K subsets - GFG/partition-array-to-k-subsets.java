// { Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
        public boolean canPartitionKSubsets_(int[]nums,int idx,int k,boolean[]vis,int tar,int sumSF){
        if(k==0)return true;
        
        if(tar<sumSF)return false;
        
        if(sumSF==tar){
            return canPartitionKSubsets_(nums,0,k-1,vis,tar,0);
        }
        
        boolean res=false;
        
        for(int i=idx;i<nums.length;i++){
            if(vis[i])continue;
            
            vis[i]=true;
            res = res || canPartitionKSubsets_(nums,i+1,k,vis,tar,sumSF+nums[i]);
            vis[i]=false;
        }
        
        return res;
    }
    public boolean isKPartitionPossible(int nums[], int n, int k)
    {
	// Your code here	
        int sum=0;
        int max=0;
        
        for(int val:nums){
            sum+=val;
            max=Math.max(max,val);
        }
        
        if(sum%k!=0 || max>sum/k)return false;
        boolean[]vis=new boolean[n];
        
        return canPartitionKSubsets_(nums,0,k,vis,sum/k,0);
    }
}
