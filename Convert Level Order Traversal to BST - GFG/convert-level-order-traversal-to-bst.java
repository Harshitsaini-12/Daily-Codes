// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GFG 
{
        public  class Pair{
        Node pn=null;
        int lr=-(int)(1e9);
        int rr=(int)1e9;

        Pair(Node pn,int lr,int rr){
            this.pn=pn;
            this.lr=lr;
            this.rr=rr;
        }

        Pair(){

        }
    }
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] LevelOrder)
    {
        //Write your code here 
        LinkedList<Pair>q=new LinkedList<>();
        int n=LevelOrder.length;
        int idx=0;
        q.addLast(new Pair());
        Node root=null;

        while(q.size()!=0 && idx<n){
            Pair rem=q.removeFirst();

            int elem=LevelOrder[idx];
            
            if(elem<rem.lr || elem>rem.rr)continue;

            Node node=new Node(elem);
            idx++;

            if(rem.pn==null)root=node;
            else{
                Node pnode=rem.pn;

                if(elem<pnode.data)pnode.left=node;
                else pnode.right=node;
            }

            q.addLast(new Pair(node,rem.lr,elem));
            q.addLast(new Pair(node,elem,rem.rr));

        }

        return root;
    }
}