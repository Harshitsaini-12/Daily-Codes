/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    class BSTPair{
      public:
        bool isBal=true;
        int h=-1;
    };
    
    BSTPair ans(TreeNode*root){
        if(root==NULL){
            BSTPair base;
            return base;
        }
        
        BSTPair lft=ans(root->left);
        BSTPair rft=ans(root->right);
        
        BSTPair mypair;
        mypair.isBal=lft.isBal && rft.isBal;
        
        if(mypair.isBal && abs(lft.h-rft.h)<2){
            mypair.h=max(lft.h,rft.h)+1;
        }else{
            mypair.isBal=false;
        }
        
        return mypair;
        
    }
    
    bool isBalanced(TreeNode* root) {
        return ans(root).isBal;
    }
};