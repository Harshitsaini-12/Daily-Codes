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
    void filllist(TreeNode* root,int targetSum,vector<vector<int>>&ans, vector<int>sans){
        if(root==NULL)return;
        
        if(root->left==NULL && root->right==NULL && targetSum==root->val){
            sans.push_back(root->val);
            ans.push_back(sans);
            return;
        }
        
        sans.push_back(root->val);
        filllist(root->left,targetSum-root->val,ans,sans);
        filllist(root->right,targetSum-root->val,ans,sans);
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
         vector<vector<int>>ans;
        filllist(root,targetSum,ans,{});
        return ans;
    }
};