// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends


class Solution
{
    //Function to insert heap.
    private static PriorityQueue<Integer>small=new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer>large=new PriorityQueue<>();
    private static boolean even=true;
 
    
    public static void insertHeap(int x)
    {
        // add your code here
         if(even){
            large.offer(x);
            small.offer(large.poll());
        }else{
            small.offer(x);
            large.offer(small.poll());
        }
        
        even=!even;
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
         if(even){
            return (small.peek()+large.peek())/2.0;
        }else{
            return small.peek();
        }
    }
    
}