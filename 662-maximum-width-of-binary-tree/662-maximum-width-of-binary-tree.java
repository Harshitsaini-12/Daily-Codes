/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class Pair{
        TreeNode node=null;
        int idx=0;
        
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair>q=new LinkedList<>();
        
        q.addLast(new Pair(root,0));
        int max=0;
        
        while(q.size()>0){
            int size=q.size();
            int lmax=q.getFirst().idx;
            int rmax=q.getFirst().idx;
            
            while(size-->0){
                Pair top=q.removeFirst();
                rmax=top.idx;
                
                if(top.node.left!=null)q.addLast(new Pair(top.node.left,top.idx*2+1));
                
                if(top.node.right!=null)q.addLast(new Pair(top.node.right,top.idx*2+2));
            }
            max=Math.max(max,rmax-lmax+1);
        }
        
        return max;
    }
}