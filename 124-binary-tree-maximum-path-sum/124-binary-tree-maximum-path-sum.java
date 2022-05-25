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
    public int max(int... arr){
        int max=arr[0];
        for(int val:arr){
            max=Math.max(max,val);
        }
        return max;
    }
    
    int maxroottPath=-(int)1e9;
    
    public int maxpath(TreeNode root){
        if(root==null)return 0;
        
        int lrtn=maxpath(root.left);
        int rrtn=maxpath(root.right);
        
        int rootToNode=Math.max(lrtn,rrtn)+root.val;
        
        maxroottPath=max(maxroottPath,rootToNode,root.val,lrtn+rrtn+root.val);
        
        return max(rootToNode,root.val);
    }
    
    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return maxroottPath;
    }
}