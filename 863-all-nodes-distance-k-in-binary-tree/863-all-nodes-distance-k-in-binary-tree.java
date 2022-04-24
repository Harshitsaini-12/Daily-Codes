/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void kdown(TreeNode node,int k,TreeNode blocker,List<Integer>ans){
            if(node==null || k<0 ||node==blocker)return;

            if(k==0){
             ans.add(node.val);
             return;
            }

           kdown(node.left,k-1,blocker,ans);
           kdown(node.right,k-1,blocker,ans);
       }
    
    public int distanceK_(TreeNode root,TreeNode target,int k,List<Integer>ans){
            if(root==null)return -1;

            if(root==target){
              kdown(root,k-0,null,ans);
              return 1;
            }

            int ld=distanceK_(root.left,target,k,ans);
            if(ld!=-1){
              kdown(root,k-ld,root.left,ans);
              return ld+1;
            }


            int rd=distanceK_(root.right,target,k,ans);
            if(rd!=-1){
              kdown(root,k-rd,root.right,ans);
              return rd+1;
            }

            return -1;
         }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans=new ArrayList<>();
        distanceK_(root,target,k,ans);
        return ans;
    }
}