/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if(head==NULL || head->next==NULL)return head;
        
        ListNode* dummy1=new ListNode(-1);
        ListNode* dummy2=new ListNode(-1);
        
        dummy1->next=head;
        dummy2->next=head;
        
        ListNode* small=dummy1;
        ListNode* large=dummy2;
        
        while(head!=NULL){
            if(head->val < x){
                small->next=head;
                small=small->next;
            }else{
                large->next=head;
                large=large->next;
            }
            
            head=head->next;
        }
        
        large->next=NULL;
        small->next=dummy2->next;
            
        return dummy1->next;
        
    }
};