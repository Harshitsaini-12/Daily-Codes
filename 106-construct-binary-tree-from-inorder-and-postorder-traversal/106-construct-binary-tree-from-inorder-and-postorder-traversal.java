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
    
    public  TreeNode buildTree(int[]inorder,int isi,int iei,int[]postorder,int psi,int pei){
        if(psi>pei)return null;
        
        int idx=isi;
        while(inorder[idx]!=postorder[pei])idx++;
        
        TreeNode root=new TreeNode(postorder[pei]);
        
        int tnoe=idx-isi;
        
        root.left=buildTree(inorder,isi,idx-1,postorder,psi,psi+tnoe-1);
        root.right=buildTree(inorder,idx+1,iei,postorder,psi+tnoe,pei-1);
            
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return buildTree(inorder,0,n-1,postorder,0,n-1);
    }
}