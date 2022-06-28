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
    public static ListNode getmid(ListNode head){
        if(head==null || head.next==null)return head;
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public static ListNode reverse(ListNode head){
        if(head==null || head.next==null)return head;
        
        ListNode curr=head;
        ListNode prev=null;
        
        while(curr!=null){
            ListNode forw=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        
        ListNode mid=getmid(head);
        ListNode newnode=mid.next;
        
        newnode=reverse(newnode);
        
        ListNode c1=head;
        ListNode c2=newnode;
        
        boolean res=true;
        
        while(c2!=null){
            if(c1.val!=c2.val)res=false;
            c1=c1.next;
            c2=c2.next;
        }
        
        newnode=reverse(newnode);
        mid.next=newnode;
        
        return res;
    }
}