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
    int xleft;
    int xright;
    
    public int size(TreeNode node,int x){
        if(node==null)return 0;
        
        int left=size(node.left,x);
        int right=size(node.right,x);
        
        if(node.val==x){
            xleft=left;
            xright=right;
        }
        return left+right+1;
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        
        int otherside=n-(xleft+xright+1);
        int maxofThree=Math.max(otherside,Math.max(xleft,xright));
        
        int rest=n-maxofThree;
        
        if(maxofThree>rest)return true;
        else return false;
        
    }
}