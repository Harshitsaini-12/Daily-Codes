class NumArray {
    
    //segment tree
    class Node{
        int str;
        int end;
        Node left;
        Node right;
        int val;
    }
    
    public Node segment_construct(int[]nums,int low,int high){
        
        if(low==high){
            Node mynode=new Node();
            
            mynode.str=mynode.end=low;
            mynode.left=mynode.right=null;
            mynode.val=nums[low];
            
            return mynode;
        }
        
        Node node=new Node();
        node.str=low;
        node.end=high;
        
        int mid=(low+high)/2;
        
        node.left=segment_construct(nums,low,mid);
        node.right=segment_construct(nums,mid+1,high);
        
        node.val = node.left.val + node.right.val;
        
        return node;
    }
    
    Node root;
    
    public NumArray(int[] nums) {
        root=segment_construct(nums,0,nums.length-1);
    }
    
    void update(Node root,int idx,int val){
        
        if(root.str==root.end){
            root.val=val;
            return;
        }
            
        int mid=(root.str + root.end)/2;
        
        if(idx<=mid){
            update(root.left,idx,val);
        }else{
            update(root.right,idx,val);
        }
        
        root.val = root.left.val + root.right.val;
        
    }
    
    public void update(int index, int val) {
        update(root,index,val);
    }
    
    public int query(Node node,int left,int right){
        
        if(left>node.end || node.str>right){
            return 0;
        }else if(node.str>=left && node.end<=right){
            return node.val;
        }else{
            int lval=query(node.left,left,right);
            int rval=query(node.right,left,right);
            
            return lval+rval;
        }
    }
    
    public int sumRange(int left, int right) {
        return query(root,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */