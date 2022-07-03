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
    public TreeNode rightmost(TreeNode node,TreeNode curr){
        while(node.right!=null && node.right!=curr){
            node=node.right;
        }
        return node;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
       List<Integer>ans=new ArrayList<>();
        
      TreeNode curr=root;
        
        while(curr!=null){
            TreeNode left=curr.left;
            if(left==null){
                ans.add(curr.val);
                curr=curr.right;
            }else{
                TreeNode rightmostnode=rightmost(left,curr);
                if(rightmostnode.right==null){
                    rightmostnode.right=curr;
                    ans.add(curr.val);
                    curr=curr.left;
                }else{
                    rightmostnode.right=null;
                    curr=curr.right;
                }
            }
        }
        
        return ans;
    }
}