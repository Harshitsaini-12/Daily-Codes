/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    public void preorder(TreeNode node,StringBuilder sb){
        if(node==null)return;
        
        sb.append(node.val + " ");
        preorder(node.left,sb);
        preorder(node.right,sb);
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root,sb);
        
        return sb.toString();
    }
    
    public TreeNode preorder_(int[]preorder,int lr,int rr,int[]idx){
        int i=idx[0];
        
        if(i>=preorder.length || preorder[i]<lr || preorder[i]>rr)return null;
        
        TreeNode root=new TreeNode(preorder[i]);
        idx[0]++;
        
        root.left=preorder_(preorder,lr,root.val,idx);
        root.right=preorder_(preorder,root.val,rr,idx);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        
        String[]arr=data.split(" ");
        int[]preorder=new int[arr.length];
        int[]idx=new int[1];
        
        for(int i=0;i<arr.length;i++){
            preorder[i]=Integer.parseInt(arr[i]);
        }
        
        return preorder_(preorder,-(int)(1e9),(int)(1e9),idx);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;