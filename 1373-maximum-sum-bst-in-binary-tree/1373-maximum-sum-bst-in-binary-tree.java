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
    
    public class MyNode{
        int min;
        int max;
        int sum;
        
        MyNode(int min,int max,int sum){
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    
    private MyNode largestSubtree_(TreeNode root){
        if(root==null){
           return new MyNode(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        
        MyNode lft=largestSubtree_(root.left);
        MyNode rft=largestSubtree_(root.right);
        
        if(lft.max>=root.val || rft.min<=root.val){
            return new MyNode(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        
        int sum=lft.sum+rft.sum+root.val;
        
        result=Math.max(result,sum);
        
        return new MyNode(Math.min(root.val,lft.min),Math.max(root.val,rft.max),sum);
    }
    
    int result=Integer.MIN_VALUE;
    
    public int maxSumBST(TreeNode root) {
        largestSubtree_(root);
        return result < 0 ? 0 : result;
    }
}