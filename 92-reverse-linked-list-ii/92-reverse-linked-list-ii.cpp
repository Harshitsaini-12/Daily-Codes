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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode* temp=head;
        vector<int>ans;
        
        while(temp!=NULL){
            ans.push_back(temp->val);
            temp=temp->next;
        }
        
        left--;
        right--;
        
        while(left<right){
            swap(ans[left++],ans[right--]);
        }
        
        temp=head;
        int i=0;
        
        while(i<ans.size()){
            temp->val=ans[i++];
            temp=temp->next;
        }
        
        return head;
    }
};