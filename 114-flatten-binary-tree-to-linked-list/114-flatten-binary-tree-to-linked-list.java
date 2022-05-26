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
    public TreeNode flatten_(TreeNode node){
        
        if(node==null || (node.left==null && node.right==null))return node;
        
        TreeNode leftTail=flatten_(node.left);
        TreeNode rightTail=flatten_(node.right);
        
        if(leftTail!=null){
            leftTail.right=node.right;
            node.right=node.left;
            node.left=null;
        }
        
        return rightTail!=null?rightTail:leftTail;
    }
    
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten_(root);
    }
}