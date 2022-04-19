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
    public ListNode merege2sort(ListNode n1,ListNode n2){
        if(n1==null)return n2;
        if(n2==null)return n1;
        
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;
        ListNode c1=n1;
        ListNode c2=n2;
        
        while(c1!=null && c2!=null){
            if(c1.val<c2.val){
                prev.next=c1;
                c1=c1.next;
            }else{
                prev.next=c2;
                c2=c2.next;
            }
            
            prev=prev.next;
        }
        
        prev.next=c1!=null?c1:c2;
        return dummy.next;
        
    }
    
    public ListNode Ksort(ListNode[] lists,int s,int e){
        if(s==e)return lists[s];
         
        int mid=(s+e)/2;
        
        ListNode n1=Ksort(lists,s,mid);
        ListNode n2=Ksort(lists,mid+1,e);
        
        ListNode ans=merege2sort(n1,n2);
        return ans;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        
        return Ksort(lists,0,lists.length-1);
    }
}