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
    List<Integer>in=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return buildTree(root,0,in.size()-1);
    }
    
    public void inorder(TreeNode root){
        if(root==null)return;
        
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
    }
    
    public TreeNode buildTree(TreeNode root,int s,int e){
        if(s>e)return null;
        
        int mid=(s+e)/2;
        
        TreeNode node=new TreeNode(in.get(mid));
        
        node.left=buildTree(root,s,mid-1);
        node.right=buildTree(root,mid+1,e);
        
        return node;
    }
}