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
    ListNode* swapNodes(ListNode* head, int k) {
        if(head==NULL ||head->next==NULL)return head;
        
        ListNode*slow=head;
        ListNode*fast=head;
        ListNode*x=head;
        
        int count=1;
        while(count<k){
            fast=fast->next;
            x=fast;
            count++;
        }
        
        while(fast->next!=NULL){
            slow=slow->next;
            fast=fast->next;
        }
        
        int temp=x->val;
        x->val=slow->val;
        slow->val=temp;

       return head;        
    }
};