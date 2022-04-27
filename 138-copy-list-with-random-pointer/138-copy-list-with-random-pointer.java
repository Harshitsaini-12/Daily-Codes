/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>hm=new HashMap<>();
        
        Node nhead=new Node(-1);
        Node curr=head;
        Node prev=nhead;
        
        while(curr!=null){
            Node node=new Node(curr.val);
            prev.next=node;
            hm.put(curr,node);
            
            curr=curr.next;
            prev=prev.next;
        }
        
        nhead=nhead.next;
        Node c1=head;
        Node c2=nhead;
        
        while(c1!=null){
            c2.random=c1.random!=null?hm.get(c1.random):null;
            
            c1=c1.next;
            c2=c2.next;
        }
        
        return nhead;
    }
}