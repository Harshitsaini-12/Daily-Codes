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
    public void copylist(Node head){
        Node curr=head;
        
        while(curr!=null){
            
            Node forw=curr.next;
            Node newnode=new Node(curr.val);
            
            curr.next=newnode;
            newnode.next=forw;
            
            curr=forw;
        }
    }
    
    public void copyRandomPointer(Node head){
        Node curr=head;
        
        while(curr!=null){
            
            Node random=curr.random;
            if(random!=null){
                curr.next.random=random.next;
            }
            
            curr=curr.next.next;
        }
    }
    
    public Node extractCopy(Node head){
        
        Node dummy=new Node(-1);
        Node prev=dummy;
        
        Node curr=head;
        
        while(curr!=null){
            
            prev.next=curr.next;
            curr.next=curr.next.next;
            
            prev=prev.next;
            curr=curr.next;
        }
        
        return dummy.next;
    }
    
    public Node copyRandomList(Node head) {
        
        copylist(head);
        copyRandomPointer(head);
        return extractCopy(head);
    }
}