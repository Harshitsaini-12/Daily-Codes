// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public  void width(Node root,int level,int[]minmax){
        if(root==null)return;

        minmax[1]=Math.max(minmax[1],level);
        minmax[0]=Math.min(minmax[0],level);

        width(root.left,level-1,minmax);
        width(root.right,level+1,minmax);
    }

    public  class Pair{
        Node node=null;
        int hl=0;

        Pair(Node node,int hl){
            this.node=node;
            this.hl=hl;
        }
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
                ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)return ans;
        
        int[]minmax=new int[2];
        width(root,0,minmax);

        int len=minmax[1]-minmax[0]+1;

        for(int i=0;i<len;i++)ans.add(0);

        LinkedList<Pair>q=new LinkedList<>();

        q.addLast(new Pair(root,Math.abs(minmax[0])));

        while(q.size()!=0){
            int size=q.size();

            while(size-->0){
                Pair rem=q.removeFirst();

                Node node=rem.node;
                int hl=rem.hl;

                ans.set(hl,node.data);

                if(node.left!=null)q.addLast(new Pair(node.left,hl-1));

                if(node.right!=null)q.addLast(new Pair(node.right,hl+1));
            }
        }

        return ans;
    }
}