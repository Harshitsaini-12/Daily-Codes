class LRUCache {
    //data members
    private class ListNode{
        Integer key;
        Integer value;
        ListNode next=null;
        ListNode prev=null;
        
        ListNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    private HashMap<Integer,ListNode>hm;
    private ListNode head=null;
    private ListNode tail=null;
    private int capacity;
    private int size;
    
    private void intialise(int capacity){
        this.capacity=capacity;
        this.size=0;
        hm=new HashMap<>();
        this.head=this.tail=null;
        
    }

    public LRUCache(int capacity) {
        intialise(capacity);
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        
        ListNode node=hm.get(key);
        addRecent(node);
        return node.value;
    }
    
    private void addLast(ListNode node){
        if(this.head==null)this.head=this.tail=node;
        else{
            node.prev=this.tail;
            this.tail.next=node;
            this.tail=node;
        }
        this.size++;
    }
    
    private ListNode removeFirst(){
        ListNode node=this.head;
        
        if(this.head==this.tail){
            this.head=this.tail=null;
        }else{
            this.head=node.next;
            node.next=this.head.prev=null;
        }
        this.size--;
        return node;
    }
    
    private ListNode removeLast(){
        ListNode node=this.tail;
        
        if(this.head==this.tail){
            this.head=this.tail=null;
        }else{
            this.tail=node.prev;
            node.prev=this.tail.prev=null;
        }
        this.size--;
        return node;
    }
    
    private ListNode remove(ListNode node){
        
        if(this.head==node){
            return removeFirst();
        }else if(this.tail==node){
            return removeLast();
        }else{
            ListNode prev=node.prev,forw=node.next;
            
            prev.next = forw;
            forw.prev = prev;

            node.next = node.prev = null;
            this.size--;
            return node;
        }
    }
    
    public void addRecent(ListNode node){
        if(node==this.tail){
            return;
        }
        
        remove(node);
        addLast(node);
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            ListNode node=hm.get(key);
            node.value=value;
            addRecent(node);
        }else{
            ListNode node=new ListNode(key,value);
            if(this.capacity==this.size){
                ListNode rn=removeFirst();
                hm.remove(rn.key);
            }
            
            addLast(node);
            hm.put(key,node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */