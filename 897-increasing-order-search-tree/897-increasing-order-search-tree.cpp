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
    void inorderans(TreeNode*root,vector<int>&ans){
        if(root==NULL)return;
        
        inorderans(root->left,ans);
        ans.push_back(root->val);
        inorderans(root->right,ans);
        
    }
    
    TreeNode* increasingBST(TreeNode* root) {
        vector<int>ans;
        inorderans(root,ans);
        
        TreeNode* dummy=new TreeNode(-1);
        TreeNode* newnode=dummy;
        
        for(int i=0;i<ans.size();i++){
            dummy->right=new TreeNode(ans[i]);
            dummy=dummy->right;
        }
        
        return newnode->right;
      
    }
};