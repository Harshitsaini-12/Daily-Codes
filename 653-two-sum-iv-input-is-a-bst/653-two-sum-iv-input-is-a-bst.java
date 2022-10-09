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
    public boolean findTarget(TreeNode root, int k) {
       ArrayList<Integer>res=new ArrayList<>();
        fill(root,res);
        
        int li=0;
        int ri=res.size()-1;
        
        while(li<ri){
            if(res.get(li)+res.get(ri)<k){
                li++;
            }else if(res.get(li)+res.get(ri)>k){
                ri--;
            }else{
                li++;ri--;
                return true;
            }
            
        }
        return false;
    }
    
    public static void fill(TreeNode root,ArrayList<Integer>res){
        if(root==null)return;
        
        fill(root.left,res);
        res.add(root.val);
        fill(root.right,res);
        
    }
}