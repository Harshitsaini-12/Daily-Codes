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
      int ans=0;
      public int minCameraCover(TreeNode root) {
        if(minCameraCover_(root)==-1)ans++;
        return ans;
    }
    
public int minCameraCover_(TreeNode node){
        //if node is null that means it is already covered
        if(node==null)return 1;
        
        int lans=minCameraCover_(node.left);
        int rans=minCameraCover_(node.right);
        
//if any of my child is not having camera then i have to have forcefully one camera for my child
        if(lans==-1 || rans==-1){
            ans++;
            return 0;
        }
        
//if my child both have cameras then i am already covered by them.
        if(lans==0 || rans==0){
            return 1;
        }
        
//if my child already covered and they dont have cameras that means i have to have one camera for myself.
        return -1;
    }
    
   
    
  
}