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
        int forwardSlope=-1;
        int backwardSlope=-1;
        int maxlen=0;
    }
    
    public Pair longestZigZag_(TreeNode root){
        if(root==null)return new Pair();
        
        Pair left=longestZigZag_(root.left);
        Pair right=longestZigZag_(root.right);
        
        Pair myans=new Pair();
        myans.maxlen=Math.max(Math.max(left.maxlen,right.maxlen),Math.max(left.backwardSlope,right.forwardSlope)+1);
        
    myans.backwardSlope=right.forwardSlope+1;
    myans.forwardSlope=left.backwardSlope+1;
        
        return myans;
    }
    public int longestZigZag(TreeNode root) {
        Pair ans=longestZigZag_(root);
        return ans.maxlen;
    }
}