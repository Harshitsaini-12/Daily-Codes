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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        rightans(root,1,new HashSet<>(),ans);
        return ans;
    }
    
public static void rightans(TreeNode root,int level,HashSet<Integer>hm,List<Integer>ans){
    
       if(root==null)return;
    
       if(!hm.contains(level)){
           ans.add(root.val);
           hm.add(level);
       }
    
      rightans(root.right,level+1,hm,ans);
      rightans(root.left,level+1,hm,ans);
    }
}