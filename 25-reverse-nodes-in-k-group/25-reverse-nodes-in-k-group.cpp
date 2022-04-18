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
    
    int count(ListNode *head){
        int cnt=0;
        ListNode *curr=head;
        while(curr){
            cnt++;
            curr=curr->next;
        }
        return cnt;
    }
    
    ListNode* reverseKGroup(ListNode* head, int k) {
        int c=count(head);
        if(c<k) return head;
        
        if(k==0){
            return head;
        }
        
        if(head==NULL){
            return head;
        }
        
        ListNode* curr=head;
        ListNode* prev=NULL;
        ListNode* next=NULL;
        int count=0;
        
        while(curr!=NULL && count<k){
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        
        if(next!=NULL){
            head->next=reverseKGroup(next,k);
        }
        return prev;
    }
};