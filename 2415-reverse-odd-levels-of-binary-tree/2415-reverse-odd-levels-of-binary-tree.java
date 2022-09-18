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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)return null;
       
        helper_(root.left,root.right,0);
        return root;
    }
    
    public void helper_(TreeNode n1,TreeNode n2,int level){
        
        if(n1==null || n2==null)return;
        
        if(level%2==0){
            swap(n1,n2);
        }
        
        helper_(n1.left,n2.right,level+1);
        helper_(n1.right,n2.left,level+1);
    }
    
    public void swap(TreeNode root1, TreeNode root2){
        int temp = root1.val;
        root1.val = root2.val;
        root2.val = temp;
    }
}