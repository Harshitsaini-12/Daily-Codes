// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    static class Pair{
        boolean isBal=true;
        boolean isBST=true;
        int min=(int)1e9;
        int max=-(int)(1e9);
        int size=0;
        Node largestNode=null;
    }
    
    // Return the size of the largest sub-tree which is also a BST
    
    static Pair ans(Node node){
        if(node==null){
            Pair p=new Pair();
            return p;
        }
        
        Pair lft=ans(node.left);
        Pair rft=ans(node.right);
        
        Pair mypair=new Pair();
        mypair.isBST=false;
        
        if(lft.isBST && rft.isBST && lft.max<node.data && rft.min>node.data){
            mypair.isBST=true;
            mypair.min=Math.min(lft.min,node.data);
            mypair.max=Math.max(rft.max,node.data);
            mypair.size=lft.size+rft.size+1;
            mypair.largestNode=node;
        }else{
            if(lft.size>rft.size){
                mypair.size=lft.size;
                mypair.largestNode=lft.largestNode;
            }else{
                mypair.size=rft.size;
                mypair.largestNode=rft.largestNode;
            }
        }
        
        
        return mypair;
    }
    
    static int largestBst(Node root)
    {
        // Write your code here
        
        return ans(root).size;
        
    }
    
}