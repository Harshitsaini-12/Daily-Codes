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
    
    public static int max(TreeNode node){
        if(node.right!=null){
            return max(node.right);
        }else{
            return node.val;
        }
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        
        if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else{
            if(root.left!=null && root.right!=null){
                int maxi=max(root.left);
                root.val=maxi;
                
                root.left=deleteNode(root.left,maxi);
                return root;
                
            }else if(root.left!=null){
                return root.left;
            }else if(root.right!=null){
                return root.right;
            }else{
                return null;
            }
        }
        return root;
    }
}