/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */ 
class Solution {
    ListNode th=null;
    ListNode tt=null;
    private void addFirst(ListNode node){
        if(th==null)th=tt=node;
        else{
            node.next=th;
            th=node;
        }
    }
    
    public int length(ListNode node){
        int count=0;
        
        while(node!=null){
            count++;
            node=node.next;
        }
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1)return head;
        
        int len=length(head);
        ListNode oh=null,ot=null,curr=head;
        
        while(len>=k){
           int tempk=k;
            
            while(curr!=null && tempk-->0){
                ListNode forw=curr.next;
                curr.next=null;
                addFirst(curr);
                curr=forw;
            }
            
            if(oh==null){
                oh=th;
                ot=tt;
            }else{
                ot.next=th;
                ot=tt;
            }
            
            th=tt=null;
            len-=k;
        }
        
        ot.next=curr;

        return oh;
    }
}