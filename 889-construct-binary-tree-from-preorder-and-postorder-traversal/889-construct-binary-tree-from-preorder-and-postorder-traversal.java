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
public static TreeNode constructFromPrePost_(int[] pre,int psi,int pei, int[] post,int posi,int poei){
        if(psi>pei)return null;

        TreeNode root=new TreeNode(pre[psi]);

        if(psi==pei)return root;

        int idx=posi;

        while(post[idx]!=pre[psi+1]){
            idx++;
        }

        int tnelem=idx-posi+1;

        root.left=constructFromPrePost_(pre,psi+1,psi+tnelem,post,posi,idx);
        root.right=constructFromPrePost_(pre,psi+tnelem+1,pei,post,idx+1,poei-1);

        return root;
    }
    
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n=pre.length;
        return constructFromPrePost_(pre,0,n-1,post,0,n-1);
    }
}