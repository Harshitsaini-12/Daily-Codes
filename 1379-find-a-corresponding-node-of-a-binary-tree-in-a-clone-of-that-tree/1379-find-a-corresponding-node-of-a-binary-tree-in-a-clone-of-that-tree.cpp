/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    
    TreeNode* search(TreeNode* clone,int val){
        if(clone==NULL)return NULL;
        
        TreeNode* left=search(clone->left,val);
        TreeNode* right=search(clone->right,val);
        
        if(left && left->val==val){
            return left;
        }else if(right && right->val==val){
            return right;
        }else if(clone->val==val){
            return clone;
        }
        return NULL;
    }
    
    TreeNode* getTargetCopy(TreeNode* original, TreeNode* cloned, TreeNode* target) {
        return search(cloned,target->val);
    }
};