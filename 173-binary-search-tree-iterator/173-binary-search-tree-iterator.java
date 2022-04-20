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
// height of balanced bst is logn .

class BSTIterator {
    LinkedList<TreeNode>st;

    public BSTIterator(TreeNode root) {
        st=new LinkedList<>();
        addAllLeft(root);
    }
    
    private void addAllLeft(TreeNode node){
        while(node!=null){
            this.st.addFirst(node);
            node=node.left;
        }
    }
    
    public int next() {
        TreeNode top=this.st.removeFirst();
        addAllLeft(top.right);
        
        return top.val;
    }
    
    public boolean hasNext() {
        return this.st.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */