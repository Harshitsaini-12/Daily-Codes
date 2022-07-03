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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize_(root,sb);
        return sb.toString();
    }
    
    private void serialize_(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("# ");
            return;
        }
        
        sb.append(root.val+" ");
        serialize_(root.left,sb);
        serialize_(root.right,sb);
    }
    
    private TreeNode deserialize_(String[]arr,int[]index){
        if(index[0]>arr.length || arr[index[0]].equals("#")){
            index[0]++;
            return null;
        }
        
        TreeNode root=new TreeNode(Integer.parseInt(arr[index[0]++]));
        root.left=deserialize_(arr,index);
        root.right=deserialize_(arr,index);
        
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]arr=data.split(" ");
        int[] index=new int[1];
        return deserialize_(arr,index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));