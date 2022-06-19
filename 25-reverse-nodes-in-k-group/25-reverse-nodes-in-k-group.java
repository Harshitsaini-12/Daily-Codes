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
    
    private int len(ListNode node){
        int len=0;
        while(node!=null){
            len++;
            node=node.next;
        }
        return len;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k==1)return head;
        
        ListNode curr=head;
        int len=len(head);
        ListNode oh=null;
        ListNode ot=null;
        
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