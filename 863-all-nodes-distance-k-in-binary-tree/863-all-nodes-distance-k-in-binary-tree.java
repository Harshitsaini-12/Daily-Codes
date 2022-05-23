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
    
    public void printkdistance(TreeNode root,int k,TreeNode blocker,List<Integer>ans){
        if(root==null || k<0 || root==blocker)return;
        
        if(k==0){
            ans.add(root.val);
            return;
        }
        
        printkdistance(root.left,k-1,blocker,ans);
        printkdistance(root.right,k-1,blocker,ans);
        
    }
    
    public int distance_k(TreeNode root,TreeNode target,int k,List<Integer>ans){
        if(root==null)return -1;
        
        if(root==target){
            printkdistance(root,k,null,ans);
            return 1;
        }
        
        int ld=distance_k(root.left,target,k,ans);
        if(ld!=-1){
            printkdistance(root,k-ld,root.left,ans);
            return ld+1;
        }
        
        int rd=distance_k(root.right,target,k,ans);
        if(rd!=-1){
            printkdistance(root,k-rd,root.right,ans);
            return rd+1;
        }
        
        return -1;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>ans=new ArrayList<>();
        distance_k(root,target,k,ans);
        return ans;
    }
}