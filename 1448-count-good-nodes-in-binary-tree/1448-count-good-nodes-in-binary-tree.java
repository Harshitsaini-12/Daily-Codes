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
    int good;
    public void goodNodes_(TreeNode root,int max){
        if(root==null)return;
        
        if(root.val>=max)good++;
        max=Math.max(max,root.val);
        
        goodNodes_(root.left,max);
        goodNodes_(root.right,max);
    }
    
    public int goodNodes(TreeNode root) {
       good=0;
       int max=Integer.MIN_VALUE;
       goodNodes_(root,max);
       return good;
    }
}