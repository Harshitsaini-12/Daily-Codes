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
    public class Pair{
        TreeNode node=null;
        int hl=0;

        Pair(TreeNode node,int hl){
            this.node=node;
            this.hl=hl;
        }
    }
    
    public void width(TreeNode root,int level,int[]minmax){
        if(root==null)return;

        minmax[0]=Math.min(level,minmax[0]);
        minmax[1]=Math.max(level,minmax[1]);

        width(root.left,level-1,minmax);
        width(root.right,level+1,minmax);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            return a.node.val-b.node.val;
        });

        PriorityQueue<Pair>cq=new PriorityQueue<>((a,b)->{
            return a.node.val-b.node.val;
        });

        int[]minmax=new int[2];
        width(root,0,minmax);

        int len=minmax[1]-minmax[0]+1;

        for(int i=0;i<len;i++)res.add(new ArrayList<>());

        pq.add(new Pair(root,Math.abs(minmax[0])));

        while(pq.size()!=0){
            int size=pq.size();

            while(size-->0){
                Pair rem=pq.remove();

                TreeNode node=rem.node;
                int hl=rem.hl;

                res.get(hl).add(node.val);

                if(node.left!=null)cq.add(new Pair(node.left,hl-1));

                if(node.right!=null)cq.add(new Pair(node.right,hl+1));
            }

            PriorityQueue<Pair>temp=pq;
            pq=cq;
            cq=temp;
        }
        return res;
    }
}